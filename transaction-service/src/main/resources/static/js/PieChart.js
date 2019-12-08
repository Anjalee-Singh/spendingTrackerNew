const piemap = window.catMap;
let values = [];
let labels = [];
let temp=0;
let max=[];
for (let key in piemap) {
  values.push(parseFloat(piemap[key]));
  labels.push(key);
  if (piemap[key]>temp){
  temp=piemap[key];
  max=labels;
}

}
/* function myFunction() {

document.getElementById("statsDiv").innerHTML = "hi";
} */

var piedata = [{
  values: values,
  labels: labels,  
  domain: {column: 1},
  text: max,
  textposition: 'inside', 
  name: 'Categories',
  // hoverinfo: 'label+percent+name',
  hole: .4, 
  type: 'pie'
}];

var pielayout = {
  title: 'Shopping at a glance',
  annotations: [
    {
      font: {
        size: 20
      },
      showarrow: false,
      text: 'Groups',
      x: 0.5,
      y: 0.5
    }
  ],
  height: 500,
  width: 600,
  showlegend: true,
  //grid: {rows: 1, columns: 1}
};

Plotly.newPlot('pieDiv', piedata, pielayout); 

