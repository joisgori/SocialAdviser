from django.contrib.auth.models import User, Group
from rest_framework import serializers
#from .models import Comercio, CapacidadComercio, Cita, ClienteXCola, Cola, ComercioXNormativa, ComercioXTiposervicio, Departamento, EstadoCita, Horario, HorarioXComercio, Municipio, Normativa

from .models import *

class UserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = User
        fields = ['url', 'username', 'email', 'groups']


class GroupSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Group
        fields = ['url', 'name']


class ComercioSerializer(serializers.ModelSerializer):
    class Meta:
        model = Comercio
        fields = ['id_comercio',
                  'nombre_comercio',
                  'telefono_comercio',
                  'movil_comercio',
                  'facebook_comercio',
                  'messenger_comercio',
                  'sitioweb_comercio',
                  'descripcion_comercio',
                  'id_tipocomercio',
                  'id_municipio',
                  'id_capacidad'
                  ]
        depth = 1


class CapacidadComercioSerializer(serializers.ModelSerializer):
    class Meta:
        model = CapacidadComercio
        fields = ['id_capacidad_comercio',
                  'cantidad_servidores',
                  'cantidad_max_clientes_cola'
                  ]
        # depth = 1


class CitaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cita
        fields = ['id_cita',
                  'id_comercio',
                  'id_horario',
                  'id_cliente',
                  'id_estado_cita'
                  ]
        # depth = 1


class ClienteXColaSerializer(serializers.ModelSerializer):
    class Meta:
        model = ClienteXCola
        fields = ['id_cliente', 'id_cola']

        # depth = 1


class ColaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cola
        fields = ['id_cola','tiempo_esperado', 'id_comercio', 'id_tipo_cola', 'id_tipo_servicio']

        #depth = 1


class ComercioXNormativaSerializer(serializers.ModelSerializer):
    class Meta:
        model = ComercioXNormativa
        fields = ['id_normativa', 'id_comercio']

        #depth = 1


class ComercioXTiposervicioSerializer(serializers.ModelSerializer):
    class Meta:
        model = ComercioXTiposervicio
        fields = ['id_comercio', 'id_tiposervicio']

        #depth = 1


class DepartamentoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Departamento
        fields = ['id_departamento', 'nombre_departamento']

        #depth = 1


class EstadoCitaSerializer(serializers.ModelSerializer):
    class Meta:
        model = EstadoCita
        fields = ['id_estado_cita', 'nombre_estado', 'valor_estado']

        #depth = 1


class HorarioSerializer(serializers.ModelSerializer):
    class Meta:
        model = Horario
        fields = ['id_horario', 'hora_inicio', 'hora_final', 'fecha_inicio', 'fecha_final']

        #depth = 1


class HorarioXComercioSerializer(serializers.ModelSerializer):
    class Meta:
        model = HorarioXComercio
        fields = ['id_horario', 'id_comercio']

        #depth = 1


class MunicipioSerializer(serializers.ModelSerializer):
    class Meta:
        model = Municipio
        fields = ['id_municipio', 'nombre_municipio', 'id_departamento']

        #depth = 1


class NormativaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Normativa
        fields = ['id_normativa', 'descripcion_normativa', 'adjunto_normativa', 'id_tipo_normativa', 'fecha_de_publicacion_normativa']

        #depth = 1


class TipoColaSerializer(serializers.ModelSerializer):
    class Meta:
        model = TipoCola
        fields = ['id_tipo_cola', 'nombre_tipo_cola', 'valor_tipo_cola']

        #depth = 1


class TipoComercioSerializer(serializers.ModelSerializer):
    class Meta:
        model = TipoComercio
        fields = ['id_tipo_comercio', 'nombre_tipo_comercio']

        #depth = 1


class TipoNormativaSerializer(serializers.ModelSerializer):
    class Meta:
        model = TipoNormativa
        fields = ['id_normativa', 'nombre_tipo_normativa']

        # depth = 1


class TipoServicioSerializer(serializers.ModelSerializer):
    class Meta:
        model = TipoServicio
        fields = ['id_tipo_servicio', 'nombre_tipo_servicio']

        # depth = 1