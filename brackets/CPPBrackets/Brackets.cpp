
/*
* Bracket Matching
* 
* Given a string with any permutation of brackets (), [] or {}, output
* "Correct" if the brackets are valid, or "Incorrect" if they are invalid.
*/

#include <iostream>
#include <deque>
#include <string>

using namespace std;

int main(void)
{
	string in;
	cout << "Enter a string\n > ";
	cin >> in;
	cout << "\n";

	deque<char> brackStack;
	bool valid = true; // assume valid until we find something invalid
	for (int i = 0; valid && i < in.size(); i++)
	{
		char curr = in[i];
		
		switch (curr)
		{
			case '(':
			case '[':
			case '{':
				brackStack.push_front(curr);
				break;

			case ')':
				if (!brackStack.empty() && brackStack.front() == '(')
					brackStack.pop_front();
				else
					valid = false;
				break;

			case ']':
				if (!brackStack.empty() && brackStack.front() == '[')
					brackStack.pop_front();
				else
					valid = false;
				break;

			case '}':
				if (!brackStack.empty() && brackStack.front() == '{')
					brackStack.pop_front();
				else
					valid = false;
				break;
		}
	}

	if (brackStack.size() != 0)
	{
		valid = false;
	}

	if (valid)
	{
		cout << "Correct\n";
	}
	else
	{
		cout << "Incorrect\n";
	}

	return 0;
}

