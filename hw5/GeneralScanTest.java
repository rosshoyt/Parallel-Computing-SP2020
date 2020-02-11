package hw5;
/*
 * Ross Hoyt
 * CPSC 5600, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
import utils.RandomArrayGenerator;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.toList;

/**
 * Test of GeneralScan.java using the simple concrete implementation DoubleHeap.java
 */
public class GeneralScanTest {
   private int N = 1<<6;
   private int P = 16;
   private List<Double> testList;
   private Double testListReduction;

   @Before
   public void setUp() throws Exception {
      testList = DoubleStream.of(RandomArrayGenerator.getArray(N)).boxed().collect(toList());
      testListReduction = getReductionSequentially(testList);
   }

   @Test
   public void getReduction() {
      DoubleHeap doubleHeap = new DoubleHeap(testList, P);
      Double result = doubleHeap.getReduction();
      System.out.println("Double heap reduction = " +  result + ", should = " + testListReduction);
      assert result.equals(testListReduction);
   }

   // test util that returns the reduction (sum) of a list using Java stream API
   private static Double getReductionSequentially(List<Double> list){
      return list.stream().mapToDouble(Double::doubleValue).sum();
   }

}