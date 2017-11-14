
<!-- <canvas id="myCanvas" width="400" height="250"
	style="border: 1px solid #d3d3d3;">
	 -->

<canvas id="myCanvas1" width="20" height="20"
	style="position: relative; top: 0px;"></canvas>

<script>
	var c = document.getElementById("myCanvas1");
	var ctx = c.getContext("2d");
	ctx.rect(0, 0, 20, 20);
	ctx.stroke();	
	ctx.fillStyle = 'blue';
	ctx.fill();
</script>
