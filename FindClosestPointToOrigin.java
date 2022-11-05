class point{
    int x,y;
    point(int x, int y){
        this.x=x;   this.y=y;
    }
}
class Line{
    //NOP no of points
    int NOP;    point[] p;  point orgin;
    int count =0;
    Line(int NOP){
        this.NOP = NOP;
        p = new point[NOP];
        orgin=new point(0,0);
    }

    void enqueue(point x){
        p[count++] = x;
    }
    point peek(){
        System.out.print("peek point = ");
        return p[findmin()];
    }
    point dequeue(){
        int i=findmin();
        point min = p[i];
        while (i<count-1) {
            p[i] = p[i+1];
            i++;
        }
        count--;
        System.out.print("Dequeue point = ");
        return min;
    }
    //Find distance between origin and given point
    int distance(int index){
        double x = Math.pow((p[index].x - orgin.x),2);
        double y = Math.pow((p[index].y - orgin.y),2);
        return (int)Math.sqrt(x+y);
    }

    //Return index of Minimum distanced point
    int findmin(){
        int min= Integer.MAX_VALUE; int ind=0;
        int x;
        for(int i=0; i<count; i++) {
            x = distance(i);
            if(x < min){
                min = x;
                ind =i;
            }
        }
        return ind;
    }

    void print(){
        System.out.println("Points and its distance from origin is:");
        for (int i = 0; i < count; i++) {
            System.out.print(i+1 + "=>  (" +p[i].x + "   " + p[i].y+ ")     distance="+distance(i));
            System.out.println();
        }
    }
}
public class FindClosestPointToOrigin {
    public static void main(String[] args) {
        int NOP = 5;    //no of points
        Line line = new Line(NOP);

        line.enqueue(new point(200, 100));
        line.enqueue(new point(3, 10));
        line.enqueue(new point(2, 10));
        line.enqueue(new point(20, 90));
        line.enqueue(new point(7, 9));

        line.print();

        point p = line.dequeue();
        System.out.println(p.x + "    " + p.y);

        p = line.dequeue();
        System.out.println(p.x + "    " + p.y);

    }
}
