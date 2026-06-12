var emergenciaApp = angular.module('emergenciaApp', []);

emergenciaApp.controller('LocalizacaoController', function ($scope) {
    $scope.enderecoAtual = localStorage.getItem('enderecoEmergencia') || 'Rua das Flores, 120 - Centro';
    $scope.novoEndereco = $scope.enderecoAtual;
    $scope.editando = false;

    $scope.confirmar = function () {
        localStorage.setItem('enderecoEmergencia', $scope.enderecoAtual);
        window.location.href = '/emergencia';
    };

    $scope.alterar = function () {
        $scope.editando = true;
    };

    $scope.salvar = function () {
        if ($scope.novoEndereco && $scope.novoEndereco.trim().length > 0) {
            $scope.enderecoAtual = $scope.novoEndereco.trim();
            localStorage.setItem('enderecoEmergencia', $scope.enderecoAtual);
            $scope.editando = false;
        }
    };
});

emergenciaApp.controller('EmergenciaController', function ($scope) {
    $scope.chamado = {
        endereco: localStorage.getItem('enderecoEmergencia') || 'Rua das Flores, 120 - Centro',
        pessoaEnvolvida: '',
        descricao: ''
    };

    $scope.selecionarTipo = function (tipo) {
        $scope.chamado.tipo = tipo;
    };
});
