class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n,m = len(s1),len(s2)

        if n>m :
            return False
        
        ft = [0]*26
        wt = [0]*26
        l = 0

        for i in range(0,n):
            ft[ord(s1[i])-ord('a')]+=1
            wt[ord(s2[i])-ord('a')]+=1
        if ft==wt:
            return True
        
        for r in range(n,m):
            wt[ord(s2[l])-ord('a')]-=1
            l+=1
            wt[ord(s2[r])-ord('a')]+=1
            if wt==ft:
                return True
        return False
        