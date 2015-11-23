package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or tails. The adjacency of these coins is the number of adjacent pairs of coins with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by reversing exactly one coin (that is, one of the coins must be reversed). Consecutive elements of array A represent consecutive coins in the row. Array A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 1 represents a coin with tails facing up. For example, given array A consisting of six numbers, such that:
 * <p/>
 * A[0] = 1
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 0
 * A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two pairs of adjacent coins with the same side facing up, namely (0, 1) and (4, 5). After reversing the coin represented by A[2], the adjacency equals 4, as there are four pairs of adjacent coins with the same side facing up, namely: (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher adjacency. The same adjacency can be obtained by reversing the coin represented by A[3].
 */
public class GettingMaximumAdjacencyFromCoins {
	public static void main(String[] args){
		List<Integer> listOfCoins =  Arrays.asList(1,1,0,1,0,0);
		/*List<Integer> listOfCoins = new ArrayList<>();
		listOfCoins.add(1);
		listOfCoins.add(1);
		listOfCoins.add(0);
		listOfCoins.add(1);
		listOfCoins.add(0);
		listOfCoins.add(0);
		*/
		MappingAdjacencyWithList mappingAdjacencyWithList = getListWithMaxAdjacency(listOfCoins);
		System.out.printf("To get the maximum number of adjacency wich is %d reversed coin with index %d\n" , mappingAdjacencyWithList.getAdjacency(), mappingAdjacencyWithList.getReversedIndex());
		System.out.printf("New list of coins is: \n");
		showTheList(mappingAdjacencyWithList.getCoins());
	}

	public static MappingAdjacencyWithList getListWithMaxAdjacency(List<Integer> coins){
		int adjacency = numberOfAdjacency(coins);
		MappingAdjacencyWithList mappingAdjacencyWithList = null;
		int reversedIndex = -1;
		List<Integer> listWithMaximumNumberOfAdjacency = coins;
		for (int i = 0;i < coins.size();i++){
			List<Integer> listWithReversedCoin = makeListWithOneReversedCoin(coins, i);
			int adjacencyOfListWithOneReveresedCoin = numberOfAdjacency(listWithReversedCoin);
			
			if (adjacencyOfListWithOneReveresedCoin>adjacency){
				adjacency = adjacencyOfListWithOneReveresedCoin;
				listWithMaximumNumberOfAdjacency = listWithReversedCoin;
				reversedIndex = i;
			}
			mappingAdjacencyWithList = new MappingAdjacencyWithList(adjacency, reversedIndex, listWithMaximumNumberOfAdjacency);
			
		}
		return mappingAdjacencyWithList;
		
	}
	public static List<Integer> makeListWithOneReversedCoin(List<Integer> coins, int numberOfCoinToReversed) {
		List<Integer> listWithReversedCoin = new ArrayList<>();
		for(int i = 0;i < coins.size();i++){
			if(i == numberOfCoinToReversed){
				listWithReversedCoin.add(reversingCoin(coins.get(i)));
			}
			else{
				listWithReversedCoin.add(coins.get(i));
			}
		}
		return listWithReversedCoin;
	}

	public static int numberOfAdjacency(List<Integer> listOfCoins) {
		int counter = 0;
		for(int i = 1;i < listOfCoins.size();i++){
			if(listOfCoins.get(i-1) == listOfCoins.get(i)){
				counter ++;
			}
		}
		return counter;
    }
	
	public static int reversingCoin(int coin){
		if (coin == 0){
			coin = 1;
		}
		else{
			coin = 0;
		}
		return coin;
	}
	public static void showTheList(List<Integer> listOfCoins){
		for(int i = 0;i < listOfCoins.size();i++){
			System.out.printf("		A[%d] = %d\n", i,listOfCoins.get(i));
		}
	}
}
