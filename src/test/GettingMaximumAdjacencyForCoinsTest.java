package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.GettingMaximumAdjacencyFromCoins;
import main.MappingAdjacencyWithList;

public class GettingMaximumAdjacencyForCoinsTest {

	@Test
	public void shouldConverseCoinFromZeroToOne() {
		//given
		Integer expectedResult = 1;
		int zero = 0;
		//when
		Integer result = GettingMaximumAdjacencyFromCoins.reversingCoin(zero);
		//then
		Assert.assertEquals(expectedResult, result);
	}
	@Test
	public void shouldConverseCoinFromOneToZero() {
		//given
		Integer expectedResult = 0;
		int one = 1;
		//when
		Integer result = GettingMaximumAdjacencyFromCoins.reversingCoin(one);
		//then
		Assert.assertEquals(expectedResult, result);
	}
	@Test
	public void shouldGiveTheCorrectNumberOfAdjacency() {
		//given
		Integer expectedNumberOfAdjacency = 1;
		List<Integer> listOfCoins = new ArrayList<>();
		listOfCoins.add(1);
		listOfCoins.add(1);
		listOfCoins.add(0);
		//when
		Integer result = GettingMaximumAdjacencyFromCoins.numberOfAdjacency(listOfCoins);
		//then
		Assert.assertEquals(expectedNumberOfAdjacency, result);
	}
	@Test
	public void shouldMakeListWithOneReversedCoin() {
		//given
		List<Integer> expectedResult = Arrays.asList(0,1,0);
		List<Integer> listOfCoins = Arrays.asList(1,1,0);
		//when
		List<Integer> result = GettingMaximumAdjacencyFromCoins.makeListWithOneReversedCoin(listOfCoins, 0);
		//then
		Assert.assertEquals(expectedResult, result);
	}
	@Test
	public void shouldMappingAdjacencyWithList() {
		//given
		int expectedAdjacency = 2;
		int expectedReversedIndex = 1;
		List<Integer> expextedCoins = Arrays.asList(0,1,0);
		MappingAdjacencyWithList expectedResult = new MappingAdjacencyWithList(expectedAdjacency, expectedReversedIndex, expextedCoins);
		int resultAdjacency = 2;
		int resultReversedIndex = 1;
		List<Integer> resultCoins = Arrays.asList(0,1,0);
		//when
		//then
		Assert.assertEquals(expectedResult.getAdjacency(), resultAdjacency);
		Assert.assertEquals(expectedResult.getReversedIndex(), resultReversedIndex);
		Assert.assertEquals(expectedResult.getCoins(), resultCoins);
	}
	@Test
	public void shouldGetListWithMaxAdjacency() {
		//given
		List<Integer> coins = Arrays.asList(0,1,0);
		int expectedAdjacency = 2;
		int expectedReversedIndex = 1;
		List<Integer> expextedCoins = Arrays.asList(0,0,0);
		MappingAdjacencyWithList expectedResult = new MappingAdjacencyWithList(expectedAdjacency, expectedReversedIndex, expextedCoins);
		//when
		MappingAdjacencyWithList result = GettingMaximumAdjacencyFromCoins.getListWithMaxAdjacency(coins);
		//then
		Assert.assertEquals(expectedResult.getAdjacency(), result.getAdjacency());
		Assert.assertEquals(expectedResult.getReversedIndex(), result.getReversedIndex());
		Assert.assertEquals(expectedResult.getCoins(), result.getCoins());
	}
	
}