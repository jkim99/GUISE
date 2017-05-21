function handleData() {
    var word = document.getElementById("wordfield").value;
    $.getJSON('https://words.bighugelabs.com/api/2/d64f77a1adf55bea3e4a4029a511ac47/word/json', function(stuff) {var data = stuff; callback(data)});
    // data = {noun: [1,2,3,4], test: [4,4,4,4]}

function callback(data) {
    console.log(data.noun.syn);
    var pagecount = data.noun.syn.length;
    var pages = new Array(pagecount);
    for (var x=0; x<pagecount; x++){
        pages[x] = window.open('https://www.google.com/search?q='+data.noun.syn[x]);
    }
    setTimeout(function() {
        for (var x=0; x<pagecount; x++){
            pages[x].close()
        }
        
    },5000);
  }
}
function handleHistoryEncryption(){
    
}