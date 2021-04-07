<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Test Table</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.0/normalize.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		getTestTableList();
	});

	function getTestTableList() {
		$.ajax({
			url : "/getTestTableList.json",
			type : "POST",
			dataType : "json",
			success : function(response) {
				console.info(response);
				$('tbody').html('');
				$.each(response, function(index, value) {
					$('tbody').append('<tr><td>' + value.col1 + '</td><td>' + value.col2 + '</td><td>' + value.col3 + '</td><td>' + value.col4 + '</td></tr>');
				});
			}
		});
	}

	function insertTestTable() {
		$.ajax({
			url : "/insertTestTable.json",
			type : "POST",
			dataType : "json",
			data : {
				col1 : $('#col1').val(),
				col2 : $('#col2').val(),
				col3 : $('#col3').val(),
				col4 : $('#col4').val()
			},
			success : function(response) {
				console.info(response);
				alert(response.msg);
				getTestTableList();
			}
		});
	}
	function updateTestTable() {
		if ($('tbody>tr').length === 0) {
			alert('None data!');
			return;
		}
		$.ajax({
			url : "/updateTestTable.json",
			type : "POST",
			dataType : "json",
			data : {
				col1 : $('tbody>tr').first().children('td').first().text(),
				col2 : $('#col2').val(),
				col3 : $('#col3').val(),
				col4 : $('#col4').val()
			},
			success : function(response) {
				console.info(response);
				alert(response.msg);
				getTestTableList();
			}
		});
	}
	function deleteTestTable() {
		if ($('tbody>tr').length === 0) {
			alert('None data!');
			return;
		}
		$.ajax({
			url : "/deleteTestTable.json",
			type : "POST",
			dataType : "json",
			data : {
				col1 : $('tbody>tr').first().children('td').first().text()
			},
			success : function(response) {
				console.info(response);
				alert(response.msg);
				getTestTableList();
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<img src="<c:url value='/resources/img/logo.png' />" width="70px" height="60px" style="float:left;"/>
		<h2>TEST_TABLE</h2>
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>COL1</th>
						<th>COL2</th>
						<th>COL3</th>
						<th>COL4</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>

		<form class="form-horizontal">
			<div class="form-group">
				<label for="col1" class="col-sm-2 control-label">COL1</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="col1" placeholder="COL1">
				</div>
			</div>
			<div class="form-group">
				<label for="col2" class="col-sm-2 control-label">COL2</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="col2" placeholder="COL2">
				</div>
			</div>
			<div class="form-group">
				<label for="col3" class="col-sm-2 control-label">COL3</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="col3" placeholder="COL3">
				</div>
			</div>
			<div class="form-group">
				<label for="col4" class="col-sm-2 control-label">COL4</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="col4" placeholder="COL4">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default" onclick="insertTestTable();">Insert</button>
					<button type="button" class="btn btn-default" onclick="updateTestTable();">Update(first row)</button>
					<button type="button" class="btn btn-default" onclick="deleteTestTable();">Delete(first row)</button>
				</div>
			</div>
		</form>

	</div>
</body>
</html>