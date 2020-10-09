from django.contrib.auth.models import User, Group
from rest_framework import serializers
from pruebaapi.models import Comercio


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


