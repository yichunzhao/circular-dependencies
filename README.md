# circular-dependencies
solving circular DI


The bean life-cycle as in an instantiation phase, it has two sub-phases to carry out dependency injections;
the earlier one is through a constructor, and the latter one using a setter to achieve the same. 
Hence, as two beans depend on each other, one may use constructor DI and anther one use setter DI.  This may avoid the deadlock because one wait a while to get another bean's reference. 

Normally bean-factory can figure out a bean and its dependencies automatically, i.e. a bean graph. However, for a bi-directional relationship, which leads to a circular-dependency, the bean factory cannot figure out who should be cooked first, so it may cause an error, bla bla the dependent bean is not created yet. So, it needs to explicitly declare @DependOn a bean.
