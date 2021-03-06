<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- <meta charset="utf-8"> -->
<title>My HTML File</title>

<link rel="stylesheet"
	href="<c:url value="/resources/default/css/bootstrap/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/default/css/default/app.css"/>" />
<script src="<c:url value="/resources/default/lib/angular/angular.js"/>"></script>
<script
	src="<c:url value="/resources/default/js/country/countryApp.js"/>"></script>
<script
	src="<c:url value="/resources/default/js/country/countryController.js"/>"></script>
<script
	src="<c:url value="/resources/default/js/country/countryService.js"/>"></script>

</head>
<body ng-app="CountryApp">
	<div ng-controller="CountryController as ctrl"
		data-ng-init="ctrl.findAll()">
		<div class="panel panel-default">


			<!-- HEADER -->
			<div class="panel-heading">
				<span class="lead">Country List</span> <span class="lead">
					<button type="button" 
					   ng-click="ctrl.showInsertForm(); toggleModal();"
					   
						class="btn btn-primary custom-width">+</button>
				</span>
			</div>



			<!-- FORM -->
			<modal class=" panel panel-default" title="Login form" visible="showModal">

				<!-- FORM HEAD -->
				<div class="panel-heading">
					<span class="lead">Agregar Country</span>
				</div>

				<!-- FORM BODY -->
				<div class="formcontainer">

					<form ng-submit="ctrl.submit()" name="countryForm"
						class="form-horizontal">
						<input type="hidden" ng-model="ctrl.country.countryId" />



						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable text-right" 
								for="file">countryId: </label>
								<div class="col-md-5">
									<input type="text" ng-model="ctrl.country.countryId"
										name="countryId" class="username form-control input-sm"
										placeholder="Id del Country" required ng-minlength="2"
										ng-maxlength="2" />
								</div>
								<div class="col-md-3">		
									<div class="has-error" ng-show="countryForm.$dirty">
										<span ng-show="countryForm.countryId.$error.required">Required </span> 
										<span ng-show="countryForm.countryId.$error.minlength">Min length 2</span> 
										<span ng-show="countryForm.countryId.$error.maxlength">Max length 2</span>
										<span ng-show="countryForm.countryId.$invalid">Invalid </span>
									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable text-right"
								 for="file">countryName:</label>
								<div class="col-md-5">
									<input type="text" ng-model="ctrl.country.countryName"
										class="form-control input-sm"
										placeholder="Enter countryName" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable text-right"
								 for="file">regionId:</label>
								<div class="col-md-5">
									<input type="text" ng-model="ctrl.country.region.regionId" name="regionId"
										class=" form-control input-sm"
										placeholder="Ingrese Region ID" required />
									
								</div>
								<div class="col-md-3">      
                                    <div class="has-error" ng-show="countryForm.$dirty">
                                        <span ng-show="countryForm.regionId.$error.required">Required</span> 
                                        <span ng-show="countryForm.regionId.$invalid">Invalid </span>
                                    </div>
                                </div>
							</div>
						</div>

						<div class="row">
							<div class="form-actions ">
								<div class="col-md-2 "></div>
								<div class="col-md-5 ">
                                    <button type="button" 
                                        class="btn btn-primary btn-sm right" 
                                        ng-disabled="false"
                                        ng-click="ctrl.reset()">
                                        Reset 
                                    </button>   
									<button type="button" 
										class="btn btn-primary btn-sm right" 
										ng-click="ctrl.insert()"
										ng-disabled="false"
										ng-show="ctrl.showBtnInsert">
										Insert 
									</button>
                                    <button type="button" 
                                        class="btn btn-primary btn-sm right" 
                                        ng-click="ctrl.update()"
                                        ng-disabled="false"
                                        ng-show="ctrl.showBtnUpdate">
                                        Update 
                                    </button>
                                    <button type="button" 
                                        class="btn btn-primary btn-sm right" 
                                        ng-click="ctrl.delete()"
                                        ng-disabled="false"
                                        ng-show="ctrl.showBtnDelete">
                                        Delete 
                                    </button>                                    
								
								</div>
							</div>
						</div>
					</form>
				</div>
			</modal>


			<!-- TABLA -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<span class="lead">Country LIST</span> -->
<!-- 			</div> -->
			<div class="tablecontainer">

				<table class="table table-hover">
					<thead>
						<tr>
							<th>countryId</th>
							<th>countryName</th>
							<th>regionName</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="c in ctrl.countryList">
							<td><span ng-bind="c.countryId"></span></td>
							<td><span ng-bind="c.countryName"></span></td>
							<td><span ng-bind="c.region.regionName"></span></td>

							<td>
								<button type="button" ng-click="ctrl.showUpdateForm(c.countryId)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.showDeleteForm(c.countryId)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>




		</div>
	</div>






</body>
</html>
