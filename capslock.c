//https://codeforces.com/problemset/problem/131/A

#include <stdio.h>

int is_lower(char c)
{
    return (c >= 97 && c <= 122);
}

char flip_capitalization(char c)
{
    if (is_lower(c)) {
        return c - 32;
    } else {
        return c + 32;
    }
}

int main(void)
{

    char word[101];
    scanf("%s", &word);

    unsigned short caps_word = 1;

    int counter = 0;
    while (word[counter] != '\0') {

        if (counter == 0)  {
            counter++;
            continue;
        }

        if (is_lower(word[counter])) {
            caps_word = 0;
        }

        ++counter;
    }

    if (caps_word) {
        for(size_t i = 0; i < counter; ++i) {
            word[i] = flip_capitalization(word[i]);
        }
    }

    printf("%s\n", word);

    return 0; 
}