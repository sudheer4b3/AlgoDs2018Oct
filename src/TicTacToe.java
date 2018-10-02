import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class TicTacToe{
	class Points{
		boolean hor,ver,ldiag,rdiag;
	}
	class Result{
		int x,o;
	}

	boolean isTrue(Points pMat[][],char mat[][],
			char currentChar,int i,int j,int N,String direction){
		if(i>=0 && j>=0 && i<N && j<N
				&& ((direction.equals("H") && pMat[i][j].hor==false)
				|| (direction.equals("V") && pMat[i][j].ver==false)
				|| (direction.equals("LD") && pMat[i][j].ldiag==false)
				|| (direction.equals("RD") && pMat[i][j].rdiag==false)) ){
			if(currentChar=='x' || currentChar=='X'){
				if(mat[i][j]=='x' || mat[i][j]=='X')
					return true;
			}else if(currentChar=='o' || currentChar=='O'){
				if(mat[i][j]=='o' || mat[i][j]=='O')
					return true;
			}
		}
		return false;
	}

	void getPoints(char mat[][],int N,List<Result> results){
		int xPoints=0,oPoints=0;
		int it,jt,count;
		Points pMat[][]=new Points[N][N];
		String[] dir={"H","V","LD","RD"};
		for(int a=0;a<N;a++)
			for(int b=0;b<N;b++){
				pMat[a][b] = new Points();
			}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				for(int ab=0;ab<dir.length;ab++){
					it=i;jt=j;count=1;
					if(ab==0)
						++jt;
					else if(ab==1)
						++it;
					else if(ab==2){++it;--jt;}
					else{++it;++jt;}
					while(isTrue(pMat,mat,mat[i][j],it,jt,N,dir[ab])){
						++count;
						if(ab==0){
							pMat[it][jt].hor=true;
							++jt;
						}else if(ab==1){
							pMat[it][jt].ver=true;
							++it;
						}else if(ab==2){
							pMat[it][jt].ldiag=true;
							++it;--jt;
						}else{
							pMat[it][jt].rdiag=true;
							++it;++jt;
						}
						if(count>=3){
							if(mat[i][j]=='x' || mat[i][j]=='X'){
								xPoints++;
							}else{
								oPoints++;
							}
						}
					}
				}
			}
		}
		Result result = new Result();
		result.x = xPoints;
		result.o = oPoints;
		results.add(result);
	}

	public static void main(String[] args){
		TicTacToe ttt = new TicTacToe();List<Result> results = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int i=0,iNow=0,thisTest=0,tcNum=0,N=0;
		boolean flag = false;char mat[][]=null;
        while(sc.hasNextLine()){
        	i++;
        	String line=sc.nextLine();
        	if(i==1){
        			tcNum=Integer.parseInt(line);
        	}else if(flag==false){
        		thisTest++;iNow=0;
        		String rowCol[]=line.split(" ");
        		N=Integer.parseInt(rowCol[0]);
        		mat=new char[N][N];flag=true;
        	}else{
        		iNow++;
        		if(iNow<=N){
    				String[] matRow=line.split(" ");
    				for(int j=0;j<matRow.length;j++){
    					mat[iNow-1][j] = matRow[j].charAt(0);
    				}
        		}
        		if(iNow >= N){
        			flag = false;
        			ttt.getPoints(mat,N,results);
        			if(thisTest>=tcNum) {
        				for (int r=0;r<results.size();r++){
        					System.out.println(results.get(r).x+" "+results.get(r).o);
        				}
        				return;
        			}
        		}
        	}
        }
	}
}

