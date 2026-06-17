class Solution:
    def isPalindrome(self, s: str) -> bool:
        x = ''.join(char.lower() for char in s if char.isalnum())

        return x == x[::-1]