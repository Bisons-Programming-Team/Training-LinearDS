
#include <iostream>
#include <vector>
#include <list>
#include <chrono> // to time execution

using namespace std;

#define LENGTH 50000

int main(void)
{
	vector<int> dArray;
	list<int> lList;
	for (int i = 0; i < LENGTH; i++)
	{
		lList.push_back(i);
		dArray.push_back(i);
	}

	auto clock = chrono::high_resolution_clock();
	auto listStart = clock.now();

	// delete every second item in lList
	bool skip = true;
	for (auto it = lList.begin(); it != lList.end(); it++)
	{
		auto toDelete = it;
		if (!skip)
		{
			lList.erase(--toDelete);
		}
		skip = !skip;
	}

	auto listDone = clock.now();
	chrono::duration<double, milli> listTime = listDone - listStart;
	cout << "Linked list time: " << listTime.count() << "ms\n";
	cout << "New length: " << lList.size() << "\n";

	auto arrayStart = clock.now();

	for (int i = 0; i < dArray.size(); i++)
	{
		dArray.erase(dArray.begin() + i);
	}

	auto arrayDone = clock.now();
	chrono::duration<double, milli> arrayTime = arrayDone - arrayStart;
	cout << "Dynamic array time: " << arrayTime.count() << "ms\n";
	cout << "New length: " << dArray.size() << "\n";

	return 0;
}
