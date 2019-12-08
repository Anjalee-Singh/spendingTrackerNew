/* var category1 = {
  x: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
  y: [20, 14, 25, 16, 18, 22, 19, 15, 12, 16, 14, 17],
  type: 'bar',
  name: 'Clothing',
  marker: {
    color: 'rgb(48,131,187)',
    opacity: 0.7,
  }
};

var category2 = {
  x: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
  y: [19, 14, 22, 14, 16, 19, 15, 14, 10, 12, 12, 16],
  type: 'bar',
  name: 'Food',
  marker: {
    color: 'rgb(203,203,203)',
    opacity: 0.5
  }
};

var bardata = [category1, category2];

var barlayout = {
  title: '2019 Ependiture Analysis',
  xaxis: {
    tickangle: -42
  },
  barmode: 'group'
};

Plotly.newPlot('barDiv', bardata, barlayout); */

const barmap = window.catMap;
let barvalues = [];
let barlabels = [];
for (let key in barmap) {
  barvalues.push(parseFloat(barmap[key]));
  barlabels.push(key);
  if (barmap[key]>temp){
  temp=barmap[key];
}
}
  var bardata = {
  x: barlabels,
  y: barvalues,
  type: 'bar',
  // text: ['4.17 below the mean', '4.17 below the mean', '0.17 below the mean', '0.17 below the mean', '0.83 above the mean', '7.83 above the mean'],
  marker: {
    color: 'rgb(142,124,195)'
  }
};

var data = [bardata];

var barlayout = {
  title: 'Shopping across various Categories',
  font:{
    family: 'Raleway, sans-serif'
  },
  showlegend: false,
  xaxis: {
    tickangle: -45
  },
  yaxis: {
    zeroline: false,
    gridwidth: 2
  },
  bargap :0.05
};

Plotly.newPlot('barDiv', data, barlayout);