/*
 * This file was automatically generated by EvoSuite
 * Fri Sep 21 05:30:45 GMT 2018
 */

package tutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import tutorial.Person;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Person_ESTest extends Person_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Person person0 = new Person("", "");
      String string0 = person0.getLastName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Person person0 = new Person("", "");
      String string0 = person0.getFirstName();
      assertEquals("", string0);
  }
}
