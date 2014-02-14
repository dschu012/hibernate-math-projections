package domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yearly_earning")
public class YearlyEarning {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="q1")
	private BigDecimal q1;
	@Column(name="q2")
	private BigDecimal q2;
	@Column(name="q3")
	private BigDecimal q3;
	@Column(name="q4")
	private BigDecimal q4;
	
	public YearlyEarning() {
	}
	
	public YearlyEarning(long id, BigDecimal q1, BigDecimal q2, BigDecimal q3, BigDecimal q4) {
		this.id = id;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getQ1() {
		return q1;
	}
	public void setQ1(BigDecimal q1) {
		this.q1 = q1;
	}
	public BigDecimal getQ2() {
		return q2;
	}
	public void setQ2(BigDecimal q2) {
		this.q2 = q2;
	}
	public BigDecimal getQ3() {
		return q3;
	}
	public void setQ3(BigDecimal q3) {
		this.q3 = q3;
	}
	public BigDecimal getQ4() {
		return q4;
	}
	public void setQ4(BigDecimal q4) {
		this.q4 = q4;
	}
	
}
