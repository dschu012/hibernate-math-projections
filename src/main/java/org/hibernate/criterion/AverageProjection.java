package org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;

public class AverageProjection extends SimpleProjection {

	private static final long serialVersionUID = -2186265106319754960L;
	
	protected final String operator = " + ";
	protected final Object[] properties;
	
	public AverageProjection(Object... properties) {
		this.properties = properties;
	}
	
	public String toSqlString(Criteria criteria, int position,
			CriteriaQuery criteriaQuery) throws HibernateException {
		StringBuffer buffer = new StringBuffer("(");
		for(int i = 0; i < properties.length; i++) {
			if(i!=0)
				buffer.append(operator);
			if(properties[i] instanceof Number)
				buffer.append(properties[i].toString());
			else
				buffer.append(criteriaQuery.getColumn(criteria, properties[i].toString()));
		}
		buffer.append(") / " + properties.length +" as y"+position+"_");
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("(");
		for(int i = 0; i < properties.length; i++) {
			if(i!=0)
				buffer.append(operator);
			buffer.append(properties[i]);
		}
		buffer.append(")");
		return buffer.toString();
	}

	public Type[] getTypes(Criteria criteria, CriteriaQuery criteriaQuery)
			throws HibernateException {
		return new Type[]{BigDecimalType.INSTANCE};
	}


}
