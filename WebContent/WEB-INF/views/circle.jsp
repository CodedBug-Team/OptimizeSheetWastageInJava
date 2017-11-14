
<!-- <canvas id="myCanvas" width="678" height="300"></canvas> -->
<canvas id="myCanvas" width="16" height="16"
	style="position: relative; top: 0px;"></canvas>
<script>
	var canvas = document.getElementById('myCanvas');
	var context = canvas.getContext('2d');
	var centerX = canvas.width / 2;
	var centerY = canvas.height / 2;
	var radius = 8;

	context.beginPath();
	context.arc(centerX, centerY, radius, 0, 2 * Math.PI, false);
	context.fillStyle = 'pink';
	context.fill();
	context.lineWidth = 1;
	context.strokeStyle = '#003300';
	context.stroke();
</script>
