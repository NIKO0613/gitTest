#include<iostream>
#include<string>
using namespace std;
#define MAX 5//最大歌曲数目
#define User_number 4//用户数目
int shunxu[MAX];//用于存储播放歌曲顺序
int mx = 0;
struct list{
	string name;
	string songer;
	double time;
};//定义list类型

class Song
{
protected:
	
public:
	list songmenu[MAX];

	Song(int i,string name, string songer, double time)
	{

			this->songmenu[i].name = name;
			this->songmenu[i].songer = songer;
			this->songmenu[i].time = time;
			songmenu[0] = { "方圆几里", "薛之谦", 4.23 };
			songmenu[1] = { "刚刚好", "薛之谦", 4.5 };
			songmenu[2] = { "暧昧", "薛之谦", 3.9 };
			songmenu[3] = { "心安理得", "王天戈", 4.29 };
			songmenu[4] = { "侧脸", "于果", 3.37 };

	}//创建有参数的构造函数
	Song()
	{
		songmenu[0] = { "方圆几里", "薛之谦", 4.23 };
		songmenu[1] = { "刚刚好", "薛之谦", 4.5 };
		songmenu[2] = { "暧昧", "薛之谦", 3.9 };
		songmenu[3] = { "心安理得", "王天戈", 4.29 };
		songmenu[4] = { "侧脸", "于果", 3.37 };
	}//创建无参构造函数
	void play()
	{
			int i = 0;
			for (i; i < MAX; i++)
			{
					cout << i+1<<"--------------------"<<"歌名：" << songmenu[i].name
						<< "\t歌手：" << songmenu[i].songer << "\t播放时长：" << songmenu[i].time << endl;


			}
	}
	void play(int num)
	{
			cout << num+1 << "--------------------" << "歌名：" << songmenu[num].name
				<< "\t歌手：" << songmenu[num].songer << "\t播放时长：" << songmenu[num].time << endl;
	}
};//用来存放歌曲原始歌曲菜单
class Master
{
protected:

public:
	Master(int number)
	{
			shunxu[mx] = number;
			mx = mx + 1;
	}


};//用来切换歌曲
class Player
{
public:
	Player()
	{
	}
	int choose()
	{
		int choose_num;
		cout << "请选择你想唱的歌：" << endl;
		cin >> choose_num;
		if (choose_num > MAX)
		{
			cout << "error!!!";
			return 0;
		}//判断是否超出限定歌曲数目

		return choose_num-1;
	}
};//用来选歌
void main()
{
	int user_input;
	Player user_player;
	Song songs;
	for (int i = 0; i < User_number; i++)
	{
		cout << "\n\t\t---------------欢迎使用点歌------------------" << endl;
		songs.play();
		user_input = user_player.choose();
		
		Master master(user_input);
		Song save_songs(i, songs.songmenu[i].name, songs.songmenu[i].songer, songs.songmenu[i].time);//将选好的歌曲存放在save_songs中
		cout << "已选歌曲播放顺序：" << endl;
		for (int j = 0; j < i + 1; j++)
			save_songs.play(shunxu[j]);//循环输出已选好的歌曲
		cout << "\n*****************************************************" << endl;
	}
}