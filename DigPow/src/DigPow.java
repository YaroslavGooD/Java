
public class DigPow {
	public static void main(String[] args) {
		int tab = digPow(46288,3);
			System.out.print(tab);
			
//		int tab1[] = digPow(46288,3);
//		for(int k : tab1)
//			System.out.print(k);
		
	}


	public static int digPow(int n, int p) {
    	int size = 0;
    	int k = n;
    	int m = n;
    	while(n != 0) {
    		n /= 10;
      		size++;
    	}
    	int tab[] = new int[size];
    	for(int i = size - 1; i >= 0; i--) {
    		tab[i] = m % 10;
    		m /= 10;
    	} 
    	int tabSum[] = new int[size];
        for(int i = 0; i < size; i++){
        	int loop = p;
        	tabSum[i] = 1;
            while(loop > 0) {
            	tabSum[i] *= tab[i];
            	loop--;
            }
            p++;
        }
        
        
          
        int sum = 0;
        for(int i = 0; i < size; i++) {
        	sum += tabSum[i];
        }
        
          
        if(sum < k)
        	return -1;
        else
            return sum / k;
	}
}

