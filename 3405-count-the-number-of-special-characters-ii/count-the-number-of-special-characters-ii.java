class Solution{
public int numberOfSpecialChars(String w){
int[] a=new int[26],b=new int[26];
for(int i=0;i<26;i++)a[i]=-1;
for(int i=0;i<w.length();i++){
char c=w.charAt(i);
if(c>='a')a[c-'a']=i;
else if(b[c-'A']==0)b[c-'A']=i+1;}
int ans=0;
for(int i=0;i<26;i++)if(a[i]!=-1&&a[i]<b[i]-1)ans++;return ans;}}