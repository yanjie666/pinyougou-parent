app.controller('brandController' ,function($scope,$controller,brandService){


    $controller('baseController',{$scope:$scope});//继承

    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        brandService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    $scope.findPage=function (page,rows) {
        brandService.findPage(page,rows).success(
            function (reponse) {
                $scope.list = reponse.rows;
                $scope.paginationConf.totalItems = reponse.total;
            }
        );
    }




    $scope.save=function () {
        var object=brandService.add($scope.entity);
        if($scope.entity.id!=null){
            object=brandService.update($scope.entity);
        }
        object.success(
            function (reponse) {
                if(reponse.success){
                    $scope.reloadList();//重新加载
                }else{
                    alert(reponse.message);
                }
            }
        )
    };



    $scope.findOne=function(id){
        brandService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    };



    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if(reponse.success){
                    $scope.reloadList();//重新加载
                }else{
                    alert(reponse.message);
                }
            }
        )
    }


    $scope.searchEntity={}
    //条件查询
    $scope.search=function(page,rows){
        brandService.search(page,rows,$scope.searchEntity).success(
            function(response){

                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值

            }
        );
    }


});