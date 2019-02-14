import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	static int number;
	static int count; //단지갯수
	
	static int[][] house;
	static int[][] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> arraylist= new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		count=0;
		number = sc.nextInt();
		String line = new String();
		sc.nextLine();
		house = new int [number][number];
		check = new int [number][number];
		
		for(int i=0; i<number; i++) {
			line = sc.nextLine();
			for(int j=0; j<number;j++) {
				house[i][j]=line.charAt(j)-'0';//char를 int로
				check[i][j]=0;
			}
		}

		for(int i=0; i<number; i++) {
			for(int j=0; j<number;j++) {
				//집이 있고 방문하지 않은 곳
				if(house[i][j]==1 && check[i][j]==0) {
					dfs(i,j);
					arraylist.add(count);
					count=0;
				}
				check[i][j]=1;//집이 없으면 방문했다고 한다.
			}
		}
		System.out.println(arraylist.size());
		Collections.sort(arraylist);
		for(int i=0;i<arraylist.size();i++) {
			System.out.println(arraylist.get(i));
		}

	}
	static int goX[]= {-1,0,1,0};
	static int goY[]= {0,1,0,-1};
	static void dfs(int i, int j) {
		for(int k=0;k<4;k++) {
			int dx =i+goX[k];
			int dy=j+goY[k];
			if((dx>-1 && dx<number) && (dy>-1 && dy<number)) {
				check[i][j]=1;//방문하면 1로
				if(house[dx][dy]==1 && check[dx][dy]==0) {
					dfs(dx,dy);
				}
			}
		}
		count++;
	}

}
