# circular-dependencies

The bean life-cycle as in an instantiation phase, it has three sub-phases to carry out dependency injections. The earliest one is through a constructor(sub-phase, i.e. instantiating bean), the latter one as a setter invoked, and the last chance(Initializer) for DI is through a postConstruct method. As two beans depend on each other(bi-directional association), one may use constructor DI and anther one use setter DI. This avoids the circular-dependency error(it looks like a deadlock), because making one wait a while to get another bean's reference. 

![image](https://user-images.githubusercontent.com/17804600/103445358-54a54780-4c73-11eb-9661-2e26d1356b76.png)

The diagram shows a bean life-cycle, the middlebox presents the main phase, i.e. instantiation phase, in which there are three subphases we may define dependency injections. 1) Instantiate bean: constructor DI; 2) Setters called: Setter DI; 3) Initializer: @PostConstruct method called here. 

Normally bean-factory can figure out a bean and its dependencies automatically, i.e. a bean graph. However, for a bi-directional relationship, which leads to a circular-dependency, the bean factory cannot figure out who should be cooked first, so it may cause an error, bla bla the dependent bean is not created yet. So, it needs to explicitly declare @DependOn a bean, which implements DI using a setter method.
