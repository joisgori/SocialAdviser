# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey has `on_delete` set to the desired behavior.
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class CapacidadComercio(models.Model):
    id_capacidad_comercio = models.IntegerField(primary_key=True)
    cantidad_servidores = models.IntegerField()
    cantidad_max_clientes_cola = models.IntegerField(blank=True, null=True)

    def __str__(self):
        return self.id_capacidad_comercio.__str__()

    class Meta:
        db_table = 'capacidad_comercio'



class Cita(models.Model):
    id_cita = models.IntegerField(primary_key=True)
    id_comercio = models.ForeignKey('Comercio', on_delete=models.CASCADE, db_column='id_comercio')
    id_horario = models.ForeignKey('Horario', on_delete=models.CASCADE, db_column='id_horario')
    id_cliente = models.ForeignKey('Cliente', on_delete=models.CASCADE, db_column='id_cliente')
    id_estado_cita = models.ForeignKey('EstadoCita', on_delete=models.CASCADE, db_column='id_estado_cita')

    def __str__(self):
        return self.id.__str__()

    class Meta:
        db_table = 'cita'


class Cliente(models.Model):
    id_cliente = models.IntegerField(primary_key=True)
    contrasenia_cliente = models.CharField(max_length=100)
    telefono_cliente = models.CharField(max_length=9, blank=True, null=True)
    correoelectronico_cliente = models.CharField(max_length=100)
    id_municipio = models.ForeignKey('Municipio', on_delete=models.CASCADE, db_column='id_municipio')
    nombre_cliente = models.CharField(max_length=200, blank=True, default="")
    apellido_cliente = models.CharField(max_length=200, blank=True, default="")

    def __str__(self):
        return self.correoelectronico_cliente

    class Meta:
        db_table = 'cliente'


class ClienteXCola(models.Model):
    id_cliente = models.ForeignKey(Cliente, on_delete=models.CASCADE, db_column='id_cliente')
    id_cola = models.ForeignKey('Cola', on_delete=models.CASCADE, db_column='id_cola')

    def __str__(self):
        return self.id_cola.__str__()

    class Meta:
        db_table = 'cliente_x_cola'


class Cola(models.Model):
    id_cola = models.IntegerField(primary_key=True)
    tiempo_esperado = models.DateTimeField()
    id_comercio = models.ForeignKey('Comercio', on_delete=models.CASCADE, db_column='id_comercio')
    id_tipo_cola = models.ForeignKey('TipoCola', on_delete=models.CASCADE, db_column='id_tipo_cola')
    id_tipo_servicio = models.ForeignKey('TipoServicio', on_delete=models.CASCADE, db_column='id_tipo_servicio')

    def __str__(self):
        return self.id_cola.__str__()

    class Meta:
        db_table = 'cola'


class Comercio(models.Model):
    id_comercio = models.IntegerField(primary_key=True)
    nombre_comercio = models.CharField(max_length=100)
    telefono_comercio = models.CharField(max_length=9, blank=True, null=True)
    movil_comercio = models.CharField(max_length=9, blank=True, null=True)
    facebook_comercio = models.CharField(max_length=100, blank=True, null=True)
    messenger_comercio = models.CharField(max_length=100, blank=True, null=True)
    sitioweb_comercio = models.CharField(max_length=100, blank=True, null=True)
    descripcion_comercio = models.CharField(max_length=500, blank=True, null=True)
    id_tipocomercio = models.ForeignKey('TipoComercio', on_delete=models.CASCADE, db_column='id_tipocomercio', blank=True,
                                        null=True)
    id_municipio = models.ForeignKey('Municipio', on_delete=models.CASCADE, db_column='id_municipio', blank=True, null=True)
    id_capacidad = models.ForeignKey(CapacidadComercio, on_delete=models.CASCADE, db_column='id_capacidad', blank=True,
                                     null=True)
    def __str__(self):
        return self.nombre_comercio

    class Meta:
        db_table = 'comercio'


class ComercioXNormativa(models.Model):
    id_normativa = models.ForeignKey('Normativa', on_delete=models.CASCADE, db_column='id_normativa')
    id_comercio = models.ForeignKey(Comercio, on_delete=models.CASCADE, db_column='id_comercio')

    def __str__(self):
        return self.id_normativa.__str__()

    class Meta:
        db_table = 'comercio_x_normativa'


class ComercioXTiposervicio(models.Model):
    id_comercio = models.ForeignKey(Comercio, on_delete=models.CASCADE, db_column='id_comercio')
    id_tiposervicio = models.ForeignKey('TipoServicio', on_delete=models.CASCADE, db_column='id_tiposervicio')

    def __str__(self):
        return self.id_tiposervicio.__str__()

    class Meta:
        db_table = 'comercio_x_tiposervicio'


class Departamento(models.Model):
    id_departamento = models.IntegerField(primary_key=True)
    nombre_departamento = models.CharField(max_length=50)

    def __str__(self):
        return self.nombre_departamento

    class Meta:
        db_table = 'departamento'


class EstadoCita(models.Model):
    id_estado_cita = models.IntegerField(primary_key=True)
    nombre_estado = models.CharField(max_length=50, blank=True, null=True)
    valor_estado = models.BooleanField()

    def __str__(self):
        return self.nombre_estado

    class Meta:
        db_table = 'estado_cita'


class Horario(models.Model):
    id_horario = models.IntegerField(primary_key=True)
    hora_inicio = models.DateTimeField()
    hora_final = models.DateTimeField(blank=True, null=True)
    fecha_inicio = models.DateField()
    fecha_final = models.DateField(blank=True, null=True)

    def __str__(self):
        return self.id_horario.__str__()

    class Meta:
        db_table = 'horario'


class HorarioXComercio(models.Model):
    id_horario = models.ForeignKey(Horario, on_delete=models.CASCADE, db_column='id_horario')
    id_comercio = models.ForeignKey(Comercio, on_delete=models.CASCADE, db_column='id_comercio')

    def __str__(self):
        return self.id_horario.__str__()

    class Meta:
        db_table = 'horario_x_comercio'


class Municipio(models.Model):
    id_municipio = models.IntegerField(primary_key=True)
    nombre_municipio = models.CharField(max_length=100)
    id_departamento = models.ForeignKey(Departamento, on_delete=models.CASCADE, db_column='id_departamento')

    def __str__(self):
        return self.nombre_municipio

    class Meta:
        db_table = 'municipio'


class Normativa(models.Model):
    id_normativa = models.IntegerField(primary_key=True)
    descripcion_normativa = models.CharField(max_length=500)
    adjunto_normativa = models.CharField(max_length=200)
    id_tipo_normativa = models.ForeignKey('TipoNormativa', on_delete=models.CASCADE, db_column='id_tipo_normativa')
    fecha_de_publicacion_normativa = models.DateField()

    def __str__(self):
        return self.id_normativa.__str__()

    class Meta:
        db_table = 'normativa'


class TipoCola(models.Model):
    id_tipo_cola = models.IntegerField(primary_key=True)
    nombre_tipo_cola = models.CharField(max_length=200)
    valor_tipo_cola = models.BooleanField()

    def __str__(self):
        return self.nombre_tipo_cola

    class Meta:
        db_table = 'tipo_cola'


class TipoComercio(models.Model):
    id_tipo_comercio = models.IntegerField(primary_key=True)
    nombre_tipo_comercio = models.CharField(max_length=100, blank=True, null=True)

    def __str__(self):
        return self.nombre_tipo_comercio

    class Meta:
        db_table = 'tipo_comercio'


class TipoNormativa(models.Model):
    id_normativa = models.IntegerField(primary_key=True)
    nombre_tipo_normativa = models.CharField(max_length=100)

    def __str__(self):
        return self.nombre_tipo_normativa

    class Meta:
        db_table = 'tipo_normativa'


class TipoServicio(models.Model):
    id_tipo_servicio = models.IntegerField(primary_key=True)
    nombre_tipo_servicio = models.CharField(max_length=100)

    def __str__(self):
        return self.nombre_tipo_servicio

    class Meta:
        db_table = 'tipo_servicio'
