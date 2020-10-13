"""SocialAd URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
from rest_framework import routers
from pruebaapi import views

router = routers.DefaultRouter()
router.register(r'users', views.UserViewSet)
router.register(r'groups', views.GroupViewSet)
router.register(r'comercios',views.ComercioViewSet)
router.register(r'departamentos', views.DepartamentoViewSet)
router.register(r'capacidad_comercio', views.CapacidadComercioViewSet)
router.register(r'citas', views.CitaViewSet)
router.register(r'clientexcola', views.ClienteXColaSet)
router.register(r'colas', views.ColaSet)
router.register(r'comercioxnormativa', views.ComercioXNormativaSet)
router.register(r'comercioxtiposervicio', views.ComercioXTipoServicioSet)
router.register(r'estadocita', views.EstadoCitaSet)
router.register(r'horarios', views.HorarioSet)
router.register(r'horariosxcomercio', views.HorarioXComercioSet)
router.register(r'municipios', views.MunicipioSet)
router.register(r'normativas', views.NormativaSet)
router.register(r'tipocola', views.TipoColaSet)
router.register(r'tipocomercio', views.TipoComercioSet)
router.register(r'tiponormativa', views.TipoNormativaSet)
router.register(r'tiposervicio', views.TipoServicioSet)

urlpatterns = [
    path('',include(router.urls)),
    path('admin/', admin.site.urls),
]
