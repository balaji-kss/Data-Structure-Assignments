//THIS FILE NEEDS TO BE EDITED BY THE STUDENT

//This class extends the abstract class binaryOperations and should include an
//implementation of the multiplication algorithm. The algorithm that should be
//implemented should be the O(n^{log 3}) Karatsuba algorithm discussed
//in class.

public class Mult3 extends binaryOperations{
    
    public myBinaryNumber multiplication(myBinaryNumber N1, myBinaryNumber N5){
        //To be implemented by the student
        int i,s,carry;
        carry = 0 ;
        int size1 = N1.getSize();
        int size2 = N5.getSize();
        myBinaryNumber N2;
        if(size1>size2){
          s = size1;
           N2 = new myBinaryNumber(s);
          for(i=0;i<size2;i++){
           try{
              N2.setBit(i,N5.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
          }
        }
        else if(size1 < size2){
          s = size2;
           N2 = new myBinaryNumber(s);
          for(i=0;i<size1;i++){
           try{
              N2.setBit(i,N1.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
        }
        }
        else{
          s = size1;
          N2 = N5;
        }
        
        
        
        myBinaryNumber C = new myBinaryNumber(size1 + size2);
        if(N1.getSize()==1 && N5.getSize()==1){
            try{
              C.setBit(0,N1.getBit(0)*N5.getBit(0));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
            
            return (C);}
         if(N1.getSize() == 2 && N5.getSize() == 1){
          try{
            C.setBit(0, N1.getBit(0)*N5.getBit(0));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          try{
            C.setBit(1, N1.getBit(1)*N5.getBit(0));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          return C;
        }
        if(N1.getSize() == 1 && N5.getSize() == 2){
          try{
            C.setBit(0, N1.getBit(0)*N5.getBit(0));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          try{
            C.setBit(1, N1.getBit(0)*N5.getBit(1));
          }catch(Exception e){e.printStackTrace();System.exit(0);}
          return C;
        }
        if(N1.getSize() <= 4 || N5.getSize() <= 4){
            Mult2 M1 = new Mult2();
            C =M1.multiplication(N1,N5);
            return C;}
            
                 
        myBinaryNumber AH = new myBinaryNumber((size1+1)/2);
        myBinaryNumber AL = new myBinaryNumber((size1+1)/2);
        myBinaryNumber BH = new myBinaryNumber((size2+1)/2);
        myBinaryNumber BL = new myBinaryNumber((size2+1)/2);
       
        for (i=0; i< size1/2; i++ ){ try{
              AL.setBit(i, N1.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
            //AL.printNumber();
        for (i = 0 ;i+(size1/2) < size1; i++ ){ try{
              AH.setBit(i, N1.getBit(i+(size1/2)));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
            //AH.printNumber();
        
        for (i=0 ;  i< size2/2;i++ ){ try{
              BL.setBit(i, N2.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
            //BL.printNumber();
       
        for (i = 0 ; i+ (size2)/2 < size2;i++ ){ try{
              BH.setBit(i, N2.getBit(i + (size2)/2));
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
           // BH.printNumber();
         myBinaryNumber A = addition(AL,AH);
         //A.printNumber();
         myBinaryNumber B = addition(BL,BH);
         //B.printNumber();
         myBinaryNumber P = multiplication(AL,BL);
         //P.printNumber();
         myBinaryNumber Q = multiplication(AH,BH);
         //Q.printNumber();
        // System.out.println(AL.getSize()+" "+AH.getSize()+" "+A.getSize());
         //System.out.println(BL.getSize()+" "+BL.getSize()+" "+B.getSize());
         myBinaryNumber R = multiplication(A,B);
         //R.printNumber();
         myBinaryNumber S = new myBinaryNumber(R.getSize());
         myBinaryNumber L = new myBinaryNumber(R.getSize());
         myBinaryNumber H = new myBinaryNumber(R.getSize());
         for(i=0;i<P.getSize();i++){
              try{
              L.setBit(i,P.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
             
         }
         //L.printNumber();
          for(i=0;i<Q.getSize();i++){
              try{
              H.setBit(i,Q.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
             
         } 
        // H.printNumber();
         
        S = subtract(R,L);
        //S.printNumber();
        S = subtract(S,H);
        //S.printNumber();
        
        myBinaryNumber D = new myBinaryNumber(size1 + size2);
        for ( i = 0 ; ( i + s< D.getSize() && i< Q.getSize()) ; i++){
          try{
            D.setBit( i + s-1, Q.getBit(i));
          }
          catch(Exception e){
            e.printStackTrace();
            System.exit(0);
          }
        }
        C = D;
        
        D = new myBinaryNumber(size1 + size2+1);
        for ( i = 0 ; ( i < D.getSize() && i< P.getSize()) ; i++){
          try{
            D.setBit( i , P.getBit(i));
          }
          catch(Exception e){
            e.printStackTrace();
            System.exit(0);
          }
        }
        C = addition(C, D);
        D = new myBinaryNumber(size1 + size2+1);
        for(i=0;(i + R.getSize()<D.getSize() && i < R.getSize()); i++){
            try{
            D.setBit( i + s/2, S.getBit(i));
          }
          catch(Exception e){
            e.printStackTrace();
            System.exit(0);
          }
        }
        C = addition(C, D); 
        return C; 
         



    }
    public myBinaryNumber subtract(myBinaryNumber N1 , myBinaryNumber N6){
            int i,size;
            int s1 = N1.getSize();
        int s2 = N6.getSize();
        myBinaryNumber N2;
        if(s1>s2){
          size = s1;
           N2 = new myBinaryNumber(size);
          for(i=0;i<s2;i++){
           try{
              N2.setBit(i,N6.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
          }
        }
        else if(s1 < s2){
          size = s2;
          N2 = new myBinaryNumber(size);
          for(i=0;i<s1;i++){
           try{
              N2.setBit(i,N1.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
        }
        }
        else{
          size = s1;
          N2 = N6;
        }
            //N1.printNumber();
            //N2.printNumber();
            myBinaryNumber N = new myBinaryNumber(N2.getSize());
            myBinaryNumber N3 = new myBinaryNumber(N2.getSize());
            for(i=0;i<size;i++){
              if(N2.getBit(i)==0){
                try{
              N2.setBit(i,1);
            }catch(Exception e){e.printStackTrace();System.exit(0);}
              }
              else{
                try{
              N2.setBit(i,0);
            }catch(Exception e){e.printStackTrace();System.exit(0);}
              }
              
            }
            //N2.printNumber();
            for(i=0;i<N2.getSize();i++){
                 try{
              N3.setBit(0,1);
            }catch(Exception e){e.printStackTrace();System.exit(0);}}
            //N3.printNumber();
            N2 = addition(N2,N3);
            //N2.printNumber();
            N = addition(N1,N2);
            size = N.getSize();
            //N.printNumber();
            myBinaryNumber N4 = new myBinaryNumber(size);
            for(i=0;i<size-2;i++){
              try{
              N4.setBit(i,N.getBit(i));
            }catch(Exception e){e.printStackTrace();System.exit(0);}
            }
            
          
         
         return N4;
}
}