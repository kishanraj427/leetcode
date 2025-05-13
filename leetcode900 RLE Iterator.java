// 900. RLE Iterator

/*  
4ms -> Beats 98.48%
Memory 43.06MB -> Beats 30.39%
*/

class RLEIterator {
    int index = 0;
    int[] data;
    public RLEIterator(int[] encoding) {
        data = encoding;
        index = 0;
    }
    
    public int next(int n) {
        while(index < data.length && n > data[index]){
            n = n - data[index];
            index += 2;
        }
        
        if(index >= data.length){
            return -1;
        }
        
        data[index] = data[index] - n;
        return data[index + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */