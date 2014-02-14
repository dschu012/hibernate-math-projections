package org.hibernate.criterion;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateTest;
import org.hibernate.transform.Transformers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.YearlyEarningBean;
import domain.YearlyEarning;

@SuppressWarnings("unchecked")
public class MathTest extends HibernateTest{

	@BeforeClass
	public static void setUp() {
		session = sessionFactory.openSession();
		YearlyEarning y = new YearlyEarning(1L, new BigDecimal(200),
												new BigDecimal(300),
												new BigDecimal(400),
												new BigDecimal(500));
		session.save(y);
	}
	
	@Test
	public void testAddOnlyProperties() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.add(new Object[]{"data.q1","data.q2","data.q3","data.q4"}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(1400).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testAdd() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.add(new Object[]{"data.q1",new BigDecimal(300),"data.q3",500L}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(1400).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testSubOnlyProperties() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.sub(new Object[]{"data.q4","data.q3","data.q2","data.q1"}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(-400).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testSub() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.sub(new Object[]{"data.q4",400,300,"data.q1"}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(-400).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testMulOnlyProperties() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.mul(new Object[]{"data.q4","data.q1"}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(100000).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testMul() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.mul(new Object[]{500.00,"data.q1"}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(100000).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testDivOnlyProperties() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.div(new Object[]{"data.q4","data.q1"}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(2.5).compareTo(result.getTotal()) == 0);
	}
	
	@Test
	public void testDiv() {
		Criteria c = session.createCriteria(YearlyEarning.class, "data")
				.setProjection(Projections.projectionList()
						.add(Projections.property("data.q1").as("q1"))
						.add(MathProjections.div(new Object[]{"data.q4",200.0}).as("total"))
				)
				.setResultTransformer(Transformers.aliasToBean(YearlyEarningBean.class));;
		List<YearlyEarningBean> results = c.list();
		assertTrue(results.size() == 1);
		YearlyEarningBean result = results.get(0);
		assertTrue(new BigDecimal(2.5).compareTo(result.getTotal()) == 0);
	}
	
	@AfterClass
	public static void tearDown() {
		session.close();
	}
	
}
