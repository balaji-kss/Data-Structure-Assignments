//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented is the simple O(n^2) Long Multiplication algorithm discussed
//in class. 

public class Mult1 extends binaryOperations{
    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
        //To be implemented by the student
        int i;
        int j;
        int carry;
        int sum,s;
        int size1 = N1.getSize();
        int size2 = N2.getSize();
        
        //public int[] N3 = new int[size1+size2];
        myBinaryNumber N3=new myBinaryNumber(size1+size2);
      /*  for(i=1;i<=size1+size2;i++)
        {
            try{
              N3.setBit(i, 0);
            }catch(Exception e){e.printStackTrace();System.exit(0);}
        }*/
       for (i=0;i<size2;i++){
           if (N2.getBit(i) == 1){
               carry = 0;
               sum = 0;
               for (j=0;j<size1;j++){
                   sum = N3.getBit(j+i) + N1.getBit(j) + carry; 
                  try{
                   N3.setBit(i+j, sum%2);
                   }catch(Exception e){e.printStackTrace();System.exit(0);}
                   carry = sum/2;
                   
                }
                j = size1;
                while(carry!=0){
                    sum = N3.getBit(i+j) + carry;
                    try{
                      N3.setBit(i+j, sum%2);
                     }catch(Exception e){e.printStackTrace();System.exit(0);}
                    carry = sum/2;
                    j = j+1;
                }


           }
       }
       return N3;
    }

public boolean mult(myBinaryNumber N1, myBinaryNumber N2){
    int i,j,k,size;
 if(i==0 || j==0){
        return false;
    }
    i = N1.getSize();
    j = N2.getSize();
   
  
    
    if(i>=j){
        size = i;
        myBinaryNumber N3 = new myBinaryNumber(size);
        
        for(k=0;k<size;k++){
            try{
                N3.setBit(i,N2.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
        }
    }
    else{size = j;
    myBinaryNumber N3 = new myBinaryNumber(size);
        
        for(k=0;k<size;k++){
            try{
                N3.setBit(i,N1.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
        } }
    for (k=0;k<size;k++){
        if(N1.getBit(k) == N2.getBit(k)){
            return true;
        }
    
    }
    return false;
}
}
    
 