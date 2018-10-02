import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class IslandOf1{
    static int ROW=0,COL=0;
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][]){
        return (row>=0) && (row<ROW) &&
               (col>=0) && (col<COL) &&
               (M[row][col]==1 && !visited[row][col]);
    }

    void DFS(int M[][], int row, int col, boolean visited[][]){
        int rowNbr[] = new int[]{-1,-1,-1,0,0,1,1,1};
        int colNbr[] = new int[]{-1,0,1,-1,1,-1,0,1};
        visited[row][col] = true;
        for (int k=0;k<8;++k)
            if (isSafe(M,row+rowNbr[k],col+colNbr[k],visited))
                DFS(M,row+rowNbr[k],col+colNbr[k],visited);
    }

    int countIslands(int M[][]){
        boolean visited[][]=new boolean[ROW][COL];
        int count = 0;
        for (int i=0;i<ROW;++i)
            for (int j=0;j<COL;++j)
                if (M[i][j]==1 && !visited[i][j]){
                    DFS(M,i,j,visited);
                    ++count;
                }
        return count;
    }

    public static void main(String[] args){
        IslandOf1 I = new IslandOf1();
        Scanner sc = new Scanner(System.in);
        int i=0,iNow=0,thisTest=0,tcNum=0;
        List<Integer> result = new LinkedList<>();
        boolean flag=false;
        int mat[][]=null;
        while(sc.hasNextLine()){
        	i++;
        	String line = sc.nextLine();
        	if(i==1){
    			tcNum = Integer.parseInt(line);
        	}else if(flag==false){
        		thisTest++;
        		iNow=0;
        		String rowCol[]=line.split(" ");
        		ROW=Integer.parseInt(rowCol[0]);
        		COL=Integer.parseInt(rowCol[1]);
        		flag = true;
        		mat = new int[ROW][COL];
        	}else{
        		iNow++;
        		if(iNow<=ROW){
    				String[] matRow = line.split(" ");
    				for(int j=0;j<matRow.length;j++)
    					mat[iNow-1][j] = Integer.parseInt(matRow[j]);
        		}
        		if(iNow>=ROW){
        			flag = false;
        			result.add(I.countIslands(mat));
        			if(thisTest>=tcNum){
        				for (int r=0;r<result.size();r++)
        					System.out.println(result.get(r));
        				return;
        			}
        		}
        	}
        }
    }
}