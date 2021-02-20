//3Color:
//Code in class:
boolean 3color(int[][]al,int deg[],int color,int vertex){
int(vertex==deg.length)
return true;
for(int i = 1 ; i <=3; i++){
if(feasible(al,deg,col,vertex,i)){
color[vetex]=i;
if(3color(al,deg,col,vertex+1))
return true;
col[vertex]=0; }}//backtracking
return false;
}