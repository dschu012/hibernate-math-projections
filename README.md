hibernate-math-projections
==========================

With Hibernate you can't do arithmetic between columns without using an sqlProjection. However, sqlProjection will only resolve the root alias. This library is a set of projections that allows simple arithmetic between columns (e.g. col1 + col2 + col3).

The projection:
```MathProjections.add(new Object[]{"data.q1","data.q2","data.q3","data.q4"}).as("total")```

Would result:
```(this_.q1 + this_.q2 + this_.q3 + this_.q4) as y0_```
