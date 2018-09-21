/*
 * This file was automatically generated by EvoSuite
 * Fri Sep 21 05:29:49 GMT 2018
 */

package tutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.collections.list.UnmodifiableList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import tutorial.Bank;
import tutorial.Company;
import tutorial.SavingsAccount;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Bank_ESTest extends Bank_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Bank bank0 = new Bank();
      Company company0 = new Company((String) null);
      SavingsAccount savingsAccount0 = new SavingsAccount(company0);
      boolean boolean0 = bank0.hasBankAccount(savingsAccount0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Bank bank0 = new Bank();
      // Undeclared exception!
      try { 
        bank0.addAccounts((UnmodifiableList) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Bank bank0 = new Bank();
      Company company0 = new Company((String) null);
      SavingsAccount savingsAccount0 = new SavingsAccount(company0);
      bank0.addAccount(savingsAccount0);
      boolean boolean0 = bank0.hasBankAccount(savingsAccount0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Bank bank0 = new Bank();
      Company company0 = new Company((String) null);
      SavingsAccount savingsAccount0 = new SavingsAccount(company0);
      bank0.removeAccount(savingsAccount0);
      assertEquals(0, savingsAccount0.getBalance());
  }
}