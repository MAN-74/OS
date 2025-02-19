class SJF{
    

    public static void sjf( Process p[],int Time){//must run evry second to check
        int min=0;

        for(int i=0;i<p.length;i++){
            if(p[i].arrivalTime<=Time){ 
                
                if(p[i+1].arrivalTime<=Time){
                    if(p[i].burstTime<p[i+1].burstTime){
                        min=p[i].id;
                    }else{
                        min=p[i+1].id;
                    }
                }else{
                    min=p[i].id; // it might cause an error
                }

            }

        }
        System.out.println("the workin now is p"+min);
        Time++;

    }

}
