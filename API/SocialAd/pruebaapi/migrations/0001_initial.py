# Generated by Django 2.2.12 on 2020-10-05 00:04

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='CapacidadComercio',
            fields=[
                ('id_capacidad_comercio', models.IntegerField(primary_key=True, serialize=False)),
                ('cantidad_servidores', models.IntegerField()),
                ('cantidad_max_clientes_cola', models.IntegerField(blank=True, null=True)),
            ],
            options={
                'db_table': 'capacidad_comercio',
            },
        ),
        migrations.CreateModel(
            name='Cliente',
            fields=[
                ('id_cliente', models.IntegerField(primary_key=True, serialize=False)),
                ('contrasenia_cliente', models.CharField(max_length=100)),
                ('telefono_cliente', models.CharField(blank=True, max_length=9, null=True)),
                ('correoelectronico_cliente', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'cliente',
            },
        ),
        migrations.CreateModel(
            name='Comercio',
            fields=[
                ('id_comercio', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_comercio', models.CharField(max_length=100)),
                ('telefono_comercio', models.CharField(blank=True, max_length=9, null=True)),
                ('movil_comercio', models.CharField(blank=True, max_length=9, null=True)),
                ('facebook_comercio', models.CharField(blank=True, max_length=100, null=True)),
                ('messenger_comercio', models.CharField(blank=True, max_length=100, null=True)),
                ('sitioweb_comercio', models.CharField(blank=True, max_length=100, null=True)),
                ('descripcion_comercio', models.CharField(blank=True, max_length=500, null=True)),
                ('id_capacidad', models.ForeignKey(blank=True, db_column='id_capacidad', null=True, on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.CapacidadComercio')),
            ],
            options={
                'db_table': 'comercio',
            },
        ),
        migrations.CreateModel(
            name='Departamento',
            fields=[
                ('id_departamento', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_departamento', models.CharField(max_length=50)),
            ],
            options={
                'db_table': 'departamento',
            },
        ),
        migrations.CreateModel(
            name='EstadoCita',
            fields=[
                ('id_estado_cita', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_estado', models.CharField(blank=True, max_length=50, null=True)),
                ('valor_estado', models.BooleanField()),
            ],
            options={
                'db_table': 'estado_cita',
            },
        ),
        migrations.CreateModel(
            name='Horario',
            fields=[
                ('id_horario', models.IntegerField(primary_key=True, serialize=False)),
                ('hora_inicio', models.DateTimeField()),
                ('hora_final', models.DateTimeField(blank=True, null=True)),
                ('fecha_inicio', models.DateField()),
                ('fecha_final', models.DateField(blank=True, null=True)),
            ],
            options={
                'db_table': 'horario',
            },
        ),
        migrations.CreateModel(
            name='TipoCola',
            fields=[
                ('id_tipo_cola', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_tipo_cola', models.CharField(max_length=200)),
                ('valor_tipo_cola', models.BooleanField()),
            ],
            options={
                'db_table': 'tipo_cola',
            },
        ),
        migrations.CreateModel(
            name='TipoComercio',
            fields=[
                ('id_tipo_comercio', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_tipo_comercio', models.CharField(blank=True, max_length=100, null=True)),
            ],
            options={
                'db_table': 'tipo_comercio',
            },
        ),
        migrations.CreateModel(
            name='TipoNormativa',
            fields=[
                ('id_normativa', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_tipo_normativa', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'tipo_normativa',
            },
        ),
        migrations.CreateModel(
            name='TipoServicio',
            fields=[
                ('id_tipo_servicio', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_tipo_servicio', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'tipo_servicio',
            },
        ),
        migrations.CreateModel(
            name='Normativa',
            fields=[
                ('id_normativa', models.IntegerField(primary_key=True, serialize=False)),
                ('descripcion_normativa', models.CharField(max_length=500)),
                ('adjunto_normativa', models.CharField(max_length=200)),
                ('fecha_de_publicacion_normativa', models.DateField()),
                ('id_tipo_normativa', models.ForeignKey(db_column='id_tipo_normativa', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.TipoNormativa')),
            ],
            options={
                'db_table': 'normativa',
            },
        ),
        migrations.CreateModel(
            name='Municipio',
            fields=[
                ('id_municipio', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_municipio', models.CharField(max_length=100)),
                ('id_departamento', models.ForeignKey(db_column='id_departamento', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Departamento')),
            ],
            options={
                'db_table': 'municipio',
            },
        ),
        migrations.CreateModel(
            name='HorarioXComercio',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_comercio', models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Comercio')),
                ('id_horario', models.ForeignKey(db_column='id_horario', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Horario')),
            ],
            options={
                'db_table': 'horario_x_comercio',
            },
        ),
        migrations.CreateModel(
            name='ComercioXTiposervicio',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_comercio', models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Comercio')),
                ('id_tiposervicio', models.ForeignKey(db_column='id_tiposervicio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.TipoServicio')),
            ],
            options={
                'db_table': 'comercio_x_tiposervicio',
            },
        ),
        migrations.CreateModel(
            name='ComercioXNormativa',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_comercio', models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Comercio')),
                ('id_normativa', models.ForeignKey(db_column='id_normativa', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Normativa')),
            ],
            options={
                'db_table': 'comercio_x_normativa',
            },
        ),
        migrations.AddField(
            model_name='comercio',
            name='id_municipio',
            field=models.ForeignKey(blank=True, db_column='id_municipio', null=True, on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Municipio'),
        ),
        migrations.AddField(
            model_name='comercio',
            name='id_tipocomercio',
            field=models.ForeignKey(blank=True, db_column='id_tipocomercio', null=True, on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.TipoComercio'),
        ),
        migrations.CreateModel(
            name='Cola',
            fields=[
                ('id_cola', models.IntegerField(primary_key=True, serialize=False)),
                ('tiempo_esperado', models.DateTimeField()),
                ('id_comercio', models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Comercio')),
                ('id_tipo_cola', models.ForeignKey(db_column='id_tipo_cola', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.TipoCola')),
                ('id_tipo_servicio', models.ForeignKey(db_column='id_tipo_servicio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.TipoServicio')),
            ],
            options={
                'db_table': 'cola',
            },
        ),
        migrations.CreateModel(
            name='ClienteXCola',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_cliente', models.ForeignKey(db_column='id_cliente', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Cliente')),
                ('id_cola', models.ForeignKey(db_column='id_cola', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Cola')),
            ],
            options={
                'db_table': 'cliente_x_cola',
            },
        ),
        migrations.AddField(
            model_name='cliente',
            name='id_municipio',
            field=models.ForeignKey(db_column='id_municipio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Municipio'),
        ),
        migrations.CreateModel(
            name='Cita',
            fields=[
                ('id_cita', models.IntegerField(primary_key=True, serialize=False)),
                ('id_cliente', models.ForeignKey(db_column='id_cliente', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Cliente')),
                ('id_comercio', models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Comercio')),
                ('id_estado_cita', models.ForeignKey(db_column='id_estado_cita', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.EstadoCita')),
                ('id_horario', models.ForeignKey(db_column='id_horario', on_delete=django.db.models.deletion.DO_NOTHING, to='pruebaapi.Horario')),
            ],
            options={
                'db_table': 'cita',
            },
        ),
    ]
