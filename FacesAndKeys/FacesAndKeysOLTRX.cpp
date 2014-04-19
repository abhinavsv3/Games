//WAP C++ program for FaceAndTheKey game(A Game By Oltrx)
/*Note:
A)Rules:
      1.The Ultimum of this game is to reach the right-bottom corner of the board.
      2.The User or Player(?) should move the key(¤).
      3.Whenever a key is moved a hole is created on the floor.
      4.The Player(?) can escape to the next floor up or down only through the hole.
      5.Key(¤) can also be moved from floor to floor but the player has to move it.
         i.e, the Key(¤) can move only one step at a time.
B)Controls:
     Controls are used to move the Player(?) one step and each step counts.Try to finish the game in lesser number of steps.
      
        w           ---->        up
       a s d      ---->   Left Down Right

  if you give 
     dddddddaaa
the program moves the Player(?) 7 steps to the right and 3 steps to the left.
C)Code:
        The program is written in such a way that the places of M and N decides the position of the Key(¤)
        So some value combinations of M and N may not work.
             (M,N) value of (9,10),(15,14),(31,30) are perfectly working.

*/
#include<iostream.h>
#include<graphics.h>
const int M=31,N=30;//sets(9,10),(15,14),(31,30) // alter values of M and N for different types of board
//ensure the M is always odd
//and both M and N are greater than 3
class FaceAndTheKey{
  	char b[M][N];
		int r,c;
	public:
		FaceAndTheKey();
		char end();
		void board();
		void level1();
		void move();
		int validate(char x);
	};
char FaceAndTheKey :: end()
{
	return b[M-2][N-2];
}	 
int FaceAndTheKey :: validate(char x)
{
	int p;char k;
	if(x == 'd'){
			if((k=b[r][c+1])==' ')
				p=1;
			else
				p=0;
		}
	else if(x == 'a'){
			if((k=b[r][c-1])==' ')
				p=1;
			else
				p=0;
		}
	else if(x == 's'){
			if((k=b[r+1][c])==' ')
				p=1;
			else
				p=0;
		}
	else if(x == 'w'){
			if((k=b[r-1][c])==' ')
				p=1;
			else
				p=0;
		}
	if(p == 0 && k==15)
		{
			p=1;b[r+1][N-c]=' ';cout<<'\a';
		}
	return p;
}
void FaceAndTheKey :: move()
{
	char x;
	x=getch();
	char temp;
	if(validate(x) == 1){
			if(x == 'd'){
					temp=b[r][c];
					b[r][c]=b[r][c+1];
					b[r][c+1]=temp;
					c++;
				}
			else if(x == 'a'){
					temp=b[r][c];
					b[r][c]=b[r][c-1];
					b[r][c-1]=temp;
					c--;
				}
			else if(x == 's')
				{
					temp=b[r][c];
					b[r][c]=b[r+2][c];
					b[r+2][c]=temp;
					r+=2;
				}
			else if(x == 'w')
				{
					temp=b[r][c];
					b[r][c]=b[r-2][c];
					b[r-2][c]=temp;
					r-=2;
				}
		}
	else{
			move();
		}
}
FaceAndTheKey :: FaceAndTheKey ()
{

	cout<<"\\*\\* \a FaceAndTheKey \a */*/\n The Game Of Logic"<<endl;
	for(int i=0;i<M;i++){
			if(i%2 == 0){
					for(int j=0;j<N;j++)
						b[i][j]='~';
				}
			else
				{b[i][0]='|';
					for(int j=1;j<N-1;j++)
						b[i][j]=' ';
					b[i][N-1]='|';
				}
		}
//Instructions Begin
cout<<"CONTROLS \n";
cout<<"For Up("<<char(24)<<")  Use w"<<endl;
cout<<"For Down("<<char(25)<<")  Use s"<<endl;
cout<<"For Right("<<char(26)<<")  Use a"<<endl;
cout<<"For Left("<<char(27)<<")  Use d"<<endl<<endl<<"_________________\n\n";
cout<<"   ::CONTROLS::\n\n";
cout<<"    "<<char(24)<<"     w";
cout<<"\n   "<<char(27)<<char(25)<<char(26)<<"   asd"<<endl;
cout<<"   ::ULTIMUM::\n\n  *Reach The Door ("<<char(219)<<')'<<endl;
cout<<"_________________\n\n\n";
//Instuction End
b[M-2][N-1]=char(219);
}
void FaceAndTheKey :: board()
{
	for(int i=0;i<M;i++){
			for(int j=0;j<N;j++)
				cout<<b[i][j];
			cout<<endl;}
}
void FaceAndTheKey :: level1()
{
	r=1;c=1;
	b[r][c]=2;
	for(int i=1,j=N-1;i<M && j<N;i=i+2,j=j-i)
		b[i][j]=15;
}
int main()
{
	FaceAndTheKey m;
	char a;
	m.level1();
	m.board();
	int j=0;
	for(int i=0;i!=1;j++){
			cout<<"Steps = "<<j<<endl;
			m.move();
			if(m.end() == 2)
				i=1;
			cout<<endl;
			system("cls");
			m.board();
		}
	cout<<"\a\aGreat Job\a\a"<<endl;
	cout<<"Number of steps ="<<j-1<<endl;
	cin>>j>>j;
	return 0;
}

