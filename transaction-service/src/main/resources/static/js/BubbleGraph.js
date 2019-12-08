const bubblemap = window.catMap;
let bubblevalues = [];
let bubblelabels = [];
for (let key in bubblemap) {
  bubblevalues.push(parseFloat(bubblemap[key]));
  bubblelabels.push(key);
  if (bubblemap[key]>temp){
  temp=bubblemap[key];
}
}

var bubbledata = {
  x: bubblelabels,
  y: bubblevalues,
  /* text: ['A<br>size: 40', 'B<br>size: 60', 'C<br>size: 80', 'D<br>size: 100'], */
  mode: 'markers',
  marker: {
    color: ['rgb(93, 164, 214)', 'rgb(255, 144, 14)',  'rgb(44, 160, 101)', 'rgb(255, 65, 54)','rgb(102, 0, 68)', 'rgb(0, 51, 43)','rgb(255, 255, 0)','rgb(0, 0, 179)', 'rgb(204, 0, 170)'],
    size: [40, 60, 75, 65,45,80,55,60,45,55]
  }
};

var data = [bubbledata];

var layout = {
  title: 'Bubble Chart Hover Text',
  showlegend: false,
  height: 500,
  width: 600
};

Plotly.newPlot('bubbleDiv', data, layout);