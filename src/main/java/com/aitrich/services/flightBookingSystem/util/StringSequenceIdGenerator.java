package com.aitrich.services.flightBookingSystem.util;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class StringSequenceIdGenerator implements IdentifierGenerator, Configurable{

	private String prefix;
	
	@Override
	public void configure(Type type, Properties params,
			ServiceRegistry serviceRegistry) throws MappingException {
		System.out.println("inside string sequence generator");
		prefix = params.getProperty("prefixx");
		System.out.println(">>>>>>>>>>>"+prefix);
		
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
			 
		String query = String.format("select %s from %s", 
			            session.getEntityPersister(obj.getClass().getName(), obj)
			              .getIdentifierPropertyName(),
			            obj.getClass().getSimpleName());
			 
		Stream<String> ids = session.createQuery(query).stream();
			 
			        Long max = ids.map(o -> o.replace(prefix + "-", ""))
			          .mapToLong(Long::parseLong)
			          .max()
			          .orElse(0L);
			 
		return prefix + "-" + (max + 1);
	}

}
