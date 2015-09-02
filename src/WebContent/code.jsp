<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8" />
  <!-- Firebase -->
  <script src="https://cdn.firebase.com/js/client/2.0.2/firebase.js"></script>

  <!-- CodeMirror and its JavaScript mode file -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/4.5.0/codemirror.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/4.5.0/mode/javascript/javascript.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/4.5.0/codemirror.css" />

  <!-- Firepad -->
  <link rel="stylesheet" href="https://cdn.firebase.com/libs/firepad/1.1.0/firepad.css" />
  <script src="https://cdn.firebase.com/libs/firepad/1.1.0/firepad.min.js"></script>
<title> Bievenu.java</title>
  <style>
    html { height: 100%; }
    body { margin: 0; height: 100%; position: relative; }
    /* Height / width / positioning can be customized for your use case.
       For demo purposes, we make firepad fill the entire browser. */
    #firepad-container {
      width: 100%;
      height: 100%;
    }
  </style>
</head>

<body>

  <div id="firepad-container"></div>
  

<script>



function init() {    
  //// Initialize Firebase.    
  //var firepadRef = getExampleRef();    
  // TODO: Replace above line with:    
   var firepadRef = new Firebase('https://intense-fire-2283.firebaseio.com/compte'+<c:out value="${ idprojet }" />+'');    

  //// Create CodeMirror (with line numbers and the JavaScript mode).    
  var codeMirror = CodeMirror(document.getElementById('firepad-container'), {    
    lineNumbers: true,    
    mode: 'javascript'    
  });    

  //// Create Firepad.    
  var firepad = Firepad.fromCodeMirror(firepadRef, codeMirror, {    
       
    defaultText: 'hello word'    
  });    
}    

// Helper to get hash from end of URL or generate a random one.    
function getExampleRef() {    
  var ref = new Firebase('https://firepad.firebaseio-demo.com');    
  var hash = window.location.hash.replace(/#/g, '');    
  if (hash) {    
    ref = ref.child(hash);    
  } else {    
    ref = ref.push(); // generate unique location.    
    window.location = window.location + '#' + ref.key(); // add it as a hash to the URL.    
  }    
  if (typeof console !== 'undefined')    
    console.log('Firebase data: ', ref.toString());    
  return ref;    
}    

init();    
 

  </script> 

  
   
  
  
  
</body>
</html>