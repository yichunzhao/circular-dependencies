# circular-dependencies
solving circular DI


The bean life-cycle as in an instantiation phase, it has two sub-phases to carry out dependency injections;
the earlier one is through a contractor, and the latter one using a setter to achieve the same. 
Hence, as two beans depend on each other, one may use constructor DI and anther one use setter DI.  This may avoid the deadlock because one wait a while to get another bean's reference. 
