#include<iostream>
#include<string>
using namespace std;
#define MAX 5//��������Ŀ
#define User_number 4//�û���Ŀ
int shunxu[MAX];//���ڴ洢���Ÿ���˳��
int mx = 0;
struct list{
	string name;
	string songer;
	double time;
};//����list����

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
			songmenu[0] = { "��Բ����", "Ѧ֮ǫ", 4.23 };
			songmenu[1] = { "�ոպ�", "Ѧ֮ǫ", 4.5 };
			songmenu[2] = { "����", "Ѧ֮ǫ", 3.9 };
			songmenu[3] = { "�İ����", "�����", 4.29 };
			songmenu[4] = { "����", "�ڹ�", 3.37 };

	}//�����в����Ĺ��캯��
	Song()
	{
		songmenu[0] = { "��Բ����", "Ѧ֮ǫ", 4.23 };
		songmenu[1] = { "�ոպ�", "Ѧ֮ǫ", 4.5 };
		songmenu[2] = { "����", "Ѧ֮ǫ", 3.9 };
		songmenu[3] = { "�İ����", "�����", 4.29 };
		songmenu[4] = { "����", "�ڹ�", 3.37 };
	}//�����޲ι��캯��
	void play()
	{
			int i = 0;
			for (i; i < MAX; i++)
			{
					cout << i+1<<"--------------------"<<"������" << songmenu[i].name
						<< "\t���֣�" << songmenu[i].songer << "\t����ʱ����" << songmenu[i].time << endl;


			}
	}
	void play(int num)
	{
			cout << num+1 << "--------------------" << "������" << songmenu[num].name
				<< "\t���֣�" << songmenu[num].songer << "\t����ʱ����" << songmenu[num].time << endl;
	}
};//������Ÿ���ԭʼ�����˵�
class Master
{
protected:

public:
	Master(int number)
	{
			shunxu[mx] = number;
			mx = mx + 1;
	}


};//�����л�����
class Player
{
public:
	Player()
	{
	}
	int choose()
	{
		int choose_num;
		cout << "��ѡ�����볪�ĸ裺" << endl;
		cin >> choose_num;
		if (choose_num > MAX)
		{
			cout << "error!!!";
			return 0;
		}//�ж��Ƿ񳬳��޶�������Ŀ

		return choose_num-1;
	}
};//����ѡ��
void main()
{
	int user_input;
	Player user_player;
	Song songs;
	for (int i = 0; i < User_number; i++)
	{
		cout << "\n\t\t---------------��ӭʹ�õ��------------------" << endl;
		songs.play();
		user_input = user_player.choose();
		
		Master master(user_input);
		Song save_songs(i, songs.songmenu[i].name, songs.songmenu[i].songer, songs.songmenu[i].time);//��ѡ�õĸ��������save_songs��
		cout << "��ѡ��������˳��" << endl;
		for (int j = 0; j < i + 1; j++)
			save_songs.play(shunxu[j]);//ѭ�������ѡ�õĸ���
		cout << "\n*****************************************************" << endl;
	}
}