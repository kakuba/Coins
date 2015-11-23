package main;

import java.util.List;

public class MappingAdjacencyWithList {
	private int adjacency;
	private int reversedIndex;
	private List<Integer> coins;
	
	public MappingAdjacencyWithList(int adjacency, int reversedIndex, List<Integer> coins){
		this.adjacency = adjacency;
		this.reversedIndex = reversedIndex;
		this.coins = coins;
	}
	
	public int getAdjacency(){
		return adjacency;
	}
	
	public int getReversedIndex(){
		return reversedIndex;
	}
	
	public List<Integer> getCoins(){
		return coins;
	}
	
}
