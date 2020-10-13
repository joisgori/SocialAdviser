from django.shortcuts import render
from django.contrib.auth.models import User, Group
from rest_framework import viewsets
from rest_framework import permissions
from .serializer import *
from .models import *

# Create your views here.
class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows user to be viewed or edited
    """
    queryset = User.objects.all().order_by('-date_joined')
    serializer_class = UserSerializer
    permission_classes = [permissions.IsAuthenticated]


class GroupViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Group.objects.all()
    serializer_class = GroupSerializer
    permission_classes = [permissions.IsAuthenticated]


class ComercioViewSet(viewsets.ModelViewSet):
    """
    API endpoint permite mostrar los comercios o editarlos.
    """
    queryset = Comercio.objects.all()
    serializer_class = ComercioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class DepartamentoViewSet(viewsets.ModelViewSet):

    queryset = Departamento.objects.all()
    serializer_class = DepartamentoSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class CapacidadComercioViewSet(viewsets.ModelViewSet):

    queryset = CapacidadComercio.objects.all()
    serializer_class = CapacidadComercioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class CitaViewSet(viewsets.ModelViewSet):

    queryset = Cita.objects.all()
    serializer_class = CitaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class ClienteXColaSet(viewsets.ModelViewSet):

    queryset = ClienteXCola.objects.all()
    serializer_class = ClienteXColaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class ColaSet(viewsets.ModelViewSet):

    queryset = Cola.objects.all()
    serializer_class = ColaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class ComercioXNormativaSet(viewsets.ModelViewSet):

    queryset = ComercioXNormativa.objects.all()
    serializer_class = ComercioXNormativaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class ComercioXTipoServicioSet(viewsets.ModelViewSet):

    queryset = ComercioXTiposervicio.objects.all()
    serializer_class = ComercioXTipoServicioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class EstadoCitaSet(viewsets.ModelViewSet):

    queryset = EstadoCita.objects.all()
    serializer_class = EstadoCitaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class HorarioSet(viewsets.ModelViewSet):

    queryset = Horario.objects.all()
    serializer_class = HorarioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class HorarioXComercioSet(viewsets.ModelViewSet):

    queryset = HorarioXComercio.objects.all()
    serializer_class = HorarioXComercioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class MunicipioSet(viewsets.ModelViewSet):

    queryset = Municipio.objects.all()
    serializer_class = MunicipioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class NormativaSet(viewsets.ModelViewSet):

    queryset = Normativa.objects.all()
    serializer_class = NormativaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class TipoColaSet(viewsets.ModelViewSet):

    queryset = TipoCola.objects.all()
    serializer_class = TipoColaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class TipoComercioSet(viewsets.ModelViewSet):

    queryset = TipoComercio.objects.all()
    serializer_class = TipoComercioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class TipoNormativaSet(viewsets.ModelViewSet):

    queryset = TipoNormativa.objects.all()
    serializer_class = TipoNormativaSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]


class TipoServicioSet(viewsets.ModelViewSet):

    queryset = TipoServicio.objects.all()
    serializer_class = TipoServicioSerializer
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]