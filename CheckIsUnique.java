
public class CheckIsUnique {
	
	public static boolean IsUnique(String str) {
		char[] str1= str.toCharArray();
		mergesort(str1,0,str1.length-1);
		for(int i=0; i<str1.length-1; i++) {
			if(str1[i]==str1[i+1])
				return false;
		}
		return true;
	}

	private static void mergesort(char[] str1, int start, int end) {
		int mid=(start+end)/2+1;
		if(start<end) {
			mergesort(str1,start,mid-1);
			mergesort(str1,mid,end);
			merge(str1,start,mid,end);
		}
		
	}

	private static void merge(char[] str1, int start, int mid, int end) {
		char[] first = new char[mid-start];
		char[] last = new char[end-mid+1];
		int i=start,j=mid, k=0;
		
		//copy both arrays to be merged
		while(k!=first.length)
			first[k++]= str1[i++];
		k=0;
		while(k!=last.length)
			last[k++]=str1[j++];
		
		//merging arrays
		i=0;
		j=0;
		k=start;

		while(i<first.length && j<last.length) {
			if(first[i]<last[j])
				str1[k++]=first[i++];
			else
				str1[k++]=last[j++];
		}
		
		//add remaining elements a half
		while(i<first.length)
			str1[k++]=first[i++];
		while(j<last.length)
			str1[k++]=last[j++];
		
	}

	public static void main(String[] args) {
		System.out.println(IsUnique("asdfghjkyui"));
	}

}
