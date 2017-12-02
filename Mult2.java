//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented should be the simple O(n^2) Divide and Conquer algorithm discussed
//in class.

public class Mult2 extends binaryOperations{
    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N2){
        
        //To be implemented by the student
        int i;
        int size1 = N1.getSize();
        int size2 = N2.getSize();
        myBinaryNumber C = new myBinaryNumber(size1 + size2);
        if(N1.getSize()==1 && N2.getSize()==1){
            try{
              C.setBit(0,N1.getBit(0)*N2.getBit(0));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
            
            return (C);}
        if(N1.getSize() == 2 && N2.getSize() == 1){
          try{
            C.setBit(0, N1.getBit(0)*N2.getBit(0));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          try{
            C.setBit(1, N1.getBit(1)*N2.getBit(0));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          return C;
        }
        if(N1.getSize() == 1 && N2.getSize() == 2){
          try{
            C.setBit(0, N1.getBit(0)*N2.getBit(0));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          try{
            C.setBit(1, N1.getBit(0)*N2.getBit(1));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          return C;
        }
        myBinaryNumber AH = new myBinaryNumber((size1+1)/2);
        myBinaryNumber AL = new myBinaryNumber((size1+1)/2);
        myBinaryNumber BH = new myBinaryNumber((size2+1)/2);
        myBinaryNumber BL = new myBinaryNumber((size2+1)/2);
       
        for (i=0; i< size1/2; i++ ){ try{
              AL.setBit(i, N1.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
        for (i = 0 ;i+(size1/2) < size1; i++ ){ try{
              AH.setBit(i, N1.getBit(i+(size1/2)));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
        
        for (i=0 ;  i< size2/2;i++ ){ try{
              BL.setBit(i, N2.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
       
        for (i = 0 ; i+ (size2)/2 < size2;i++ ){ try{
              BH.setBit(i, N2.getBit(i + (size2)/2));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
         myBinaryNumber P = multiplication(AH,BH);
         myBinaryNumber Q = multiplication(AL,BL);
         myBinaryNumber R = multiplication(AL,BH);
         myBinaryNumber S = multiplication(BL,AH);

         
        myBinaryNumber D = new myBinaryNumber(size1 + size2);
        for ( i = 0 ; ((i + (size1)/2)< D.getSize() && i< S.getSize()) ; i++){
          try{
            D.setBit( i + (size1)/2 , S.getBit(i));
          }
          catch(Exception e){
            e.printStackTrace();
            System.exit(0);
          }
        }
        C = addition(D , Q);
        D = new myBinaryNumber(size1 + size2 + 1);
        for ( i = 0 ; ((i + (size2)/2) < D.getSize() && i < R.getSize()) ; i++){
          try{
            D.setBit( i + (size2)/2, R.getBit(i));
          }
          catch(Exception e){
            e.printStackTrace();
            System.exit(0);
          }
        }
        C = addition(C, D);
        D = new myBinaryNumber(size1 + size2 + 1);
        for ( i = 0 ; (( i + (size1)/2 + (size2)/2)< D.getSize() && i< P.getSize()) ; i++){
          try{
            D.setBit( i + (size1)/2 + (size2)/2, P.getBit(i));
          }
          catch(Exception e){
            e.printStackTrace();
            System.exit(0);
          }
        }
        C = addition(C, D);
        return C;
}
}