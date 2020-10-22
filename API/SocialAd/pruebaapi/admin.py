from django.contrib import admin
from .models import Comercio, Departamento, Municipio, Cliente, Cita, Cola, TipoComercio


# Register your models here.

class ClienteAdmin(admin.ModelAdmin):
    fields = ['correoelectronico_cliente', 'telefono_cliente', 'id_municipio','nombre_cliente','apellido_cliente']


class ComercioAdmin(admin.ModelAdmin):
    fields = ['nombre_comercio', 'telefono_comercio', 'movil_comercio',
              'facebook_comercio', 'messenger_comercio', 'sitioweb_comercio',
              'descripcion_comercio', 'id_tipocomercio', 'id_municipio', 'id_capacidad']


admin.site.register(Comercio, ComercioAdmin)
admin.site.register(Departamento)
admin.site.register(Municipio)
admin.site.register(Cliente, ClienteAdmin)
admin.site.register(Cita)
admin.site.register(Cola)
admin.site.register(TipoComercio)
